// Variables for measuring request time
let csvString;

// Variables for choosing REST API endpoint and number of iterations
let restEndpoint;
let numIterations;

async function postButton() {
    // Clear output box and initialize CSV string
    $("#outputBox").text("");
    csvString = "data:text/csv;charset=utf-8,time,\n";

    // Get number of iterations and chosen REST API endpoint
    numIterations = $("#iterationsPost").val();
    restEndpoint = $("#linkPost").val();

    //create lockal storage
    localStorage.setItem('index',3);

    // Get flight data JSON file
    const response = await fetch("./flightdata.json");
    const data = await response.json();
  
    for (let i = 0; i < numIterations; i++) {
        let index = parseInt(localStorage.getItem('index'));
        //Controll random number
        Math.setSeed(index);

        let idOfRecord = Math.floor(Math.random()* index)+1;

        $("#loadBox").text(i+1 + "/" + numIterations);

        await post(data[idOfRecord]);

        localStorage.setItem('index', index+1);
    }
};

// Send a HTTP request to the chosen REST API with the provided JSON data
// Save the time it takes to send the request and get a response from the REST API
async function post(jsonData) {
    let requestStartTime =  new Date().getTime();
    await fetch(restEndpoint, {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
    })
    .then(response => {
        return response.text();
    })
    .then(responseText => {
        let requestEndTime =  new Date().getTime();
        const data = JSON.parse(responseText);
        const formattedJSON = JSON.stringify(data, null, 2);
        $("<pre>" + formattedJSON + "</pre>").appendTo("#outputBox");
        // Calculates the time it took to send the request and get a response from the REST api
        let delta = (requestEndTime - requestStartTime);
        csvString += delta + ",\n";
        getData();
    });
};

// Create a link to download a CSV file with the collected test data
function getData() {
    $( "#download" ).remove();
    const downloadAnchor = document.createElement("a");
    downloadAnchor.setAttribute("href", encodeURI(csvString));
    downloadAnchor.setAttribute("download", "my_data.csv");
    downloadAnchor.setAttribute("id", "download");
    downloadAnchor.innerHTML = "Click Here to download results";
    $( "#downloadBox" ).append(downloadAnchor);
};

async function getButton(){
    $("#outputBox").text("");
    csvString = "data:text/csv;charset=utf-8,time,param,results,\n";

    // Gets the amount of iterations and the link to the chosen REST api
    numIterations = $("#iterationsGet").val();
    restEndpoint = $("#linkGet").val();

    //create lockal storage
    localStorage.setItem('index',3);
    
    for(let i = 0; i <= numIterations-1; i++){
        let index = parseInt(localStorage.getItem('index'));
        //Controll random number
        Math.setSeed(index);

        let idOfRecord = Math.floor(Math.random()* index)+1;
        let requestStartTime =  new Date().getTime();

        await fetch(restEndpoint+"/"+idOfRecord, {
            method: 'GET',
            redirect: 'follow'
        })
        .then(response => {
            return response.text();
        })
        .then(text => {
            let requestEndTime =  new Date().getTime();
            const data = JSON.parse(text);
            const formattedJSON = JSON.stringify(data, null, 2);
            $("<pre>" + formattedJSON + "</pre>").appendTo("#outputBox");
            // Calculates the time it took to send the request and get a response from the REST api
            let delta = (requestEndTime - requestStartTime);
            csvString += delta + ",\n";
            getData();
        })
        // .catch(error => console.log('error', error));
        $("#loadBox").text(i+1 + "/" + numIterations);
        localStorage.setItem('index', index+1);
    }        


};

function getAllButton(){
    $("#outputBox").text("");

    // Gets the amount of iterations and the link to the chosen REST api
    numIterations = $("#iterationsGet").val();
    restEndpoint = $("#linkGet").val();
    getAll();
};

// Sends a HTTP request to the chosen REST api without parameters to get all flight data
// Saves the time it takes to send the request and get a response from the REST api
function getAll(){
    csvString = "data:text/csv;charset=utf-8,time,\n";
    requestStartTime =  new Date().getTime();

    fetch(restEndpoint, {
        method: 'GET'
    })
    .then(response => {
        let requestEndTime =  new Date().getTime();
        return response.text();
    })
    .then(text => {
        const data = JSON.parse(text);
        const formattedJSON = JSON.stringify(data, null, 2);
        $("<pre>" + formattedJSON + "</pre>").appendTo("#outputBox");
        // Calculates the time it took to send the request and get a response from the REST api
        let delta = (requestEndTime - requestStartTime);
        csvString += delta + ",\n";
        getData();

        
    })
    .catch(error => console.log('error', error));

};
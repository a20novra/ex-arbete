// Variables for measuring request time
let csvString;
let requestStartTime;
let requestEndTime;

// Variables for choosing REST API endpoint and number of iterations
let restEndpoint;
let numIterations;

function postButton() {
    // Clear output box and initialize CSV string
    $("#outputBox").text("");
    csvString = "data:text/csv;charset=utf-8,time,\n";

    // Get number of iterations and chosen REST API endpoint
    numIterations = $("#iterationsPost").val();
    restEndpoint = $("#linkPost").val();

    //create lockal storage
    localStorage.setItem('index',3);

    // Get flight data JSON file
    fetch("./flightdata.json")
    .then(response => response.json())
    .then(data => {
        for (let i = 0; i <= numIterations; i++) {
        let index = parseInt(localStorage.getItem('index'));
        //Controll random number
        Math.setSeed(index);

        let idOfRecord = Math.floor(Math.random()* index)+1;

        $("#loadBox").text(i + "/" + numIterations);
        post(data[idOfRecord]);
        localStorage.setItem('index', index+1);
        }
    });
};

// Send a HTTP request to the chosen REST API with the provided JSON data
// Save the time it takes to send the request and get a response from the REST API
function post(jsonData) {
    requestStartTime = performance.now();
    fetch(restEndpoint, {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
    })
    .then(response => {
        requestEndTime = performance.now();
        return response.text();
    })
    .then(responseText => {
        const data = JSON.parse(responseText);
        const formattedJSON = JSON.stringify(data, null, 2);
        $("<pre>" + formattedJSON + "</pre>").appendTo("#outputBox");
        // Calculates the time it took to send the request and get a response from the REST api
        let delta = (requestEndTime - requestStartTime).toFixed(2);
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

function getButton(){
    $("#outputBox").text("");
    csvString = "data:text/csv;charset=utf-8,time,param,results,\n";

    // Gets the amount of iterations and the link to the chosen REST api
    numIterations = $("#iterationsGet").val();
    restEndpoint = $("#linkGet").val();

    //create lockal storage
    localStorage.setItem('index',3);
    

    for(let i = 0; i <= numIterations; i++){
        let index = parseInt(localStorage.getItem('index'));
        //Controll random number
        Math.setSeed(index);

        let idOfRecord = Math.floor(Math.random()* index)+1;
        requestStartTime = performance.now();

        fetch(restEndpoint+"/"+idOfRecord, {
            method: 'GET',
            redirect: 'follow'
        })
        .then(response => {
            requestEndTime = performance.now();
            return response.text();
        })
        .then(text => {
            const data = JSON.parse(text);
            const formattedJSON = JSON.stringify(data, null, 2);
            $("<pre>" + formattedJSON + "</pre>").appendTo("#outputBox");
            // Calculates the time it took to send the request and get a response from the REST api
            let delta = (requestEndTime - requestStartTime).toFixed(2);
            csvString += delta + ",\n";
            getData();
        })
        // .catch(error => console.log('error', error));
        $("#loadBox").text(i + "/" + numIterations);
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
    requestStartTime = performance.now();

    fetch(restEndpoint, {
        method: 'GET'
    })
    .then(response => {
        requestEndTime = performance.now();
        return response.text();
    })
    .then(text => {
        const data = JSON.parse(text);
        const formattedJSON = JSON.stringify(data, null, 2);
        $("<pre>" + formattedJSON + "</pre>").appendTo("#outputBox");
        // Calculates the time it took to send the request and get a response from the REST api
        let delta = (requestEndTime - requestStartTime).toFixed(2);
        csvString += delta + ",\n";
        getData();

        
    })
    .catch(error => console.log('error', error));

};
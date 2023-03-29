<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Flightdata;

class FlightdataController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $flightdata = Flightdata::all();
        return response()->json($flightdata);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        // Validate incoming request data
        $validatedData = $request->validate([
            'airline_iata_code' => 'required|max:3',
            'airline_id' => 'required|integer',
            'source_airport_iata_code' => 'required|max:4',
            'source_airport_id' => 'required|integer',
            'destination_airport_iata_code' => 'required|max:4',
            'destination_airport_id' => 'required|integer',
            'number_of_stops' => 'required|integer',
            'equipment' => 'required|max:32'
        ]);

        // Create a new Flightdata instance with validated data
        $flightdata = new Flightdata([
            'airline_iata_code' => $validatedData['airline_iata_code'],
            'airline_id' => $validatedData['airline_id'],
            'source_airport_iata_code' => $validatedData['source_airport_iata_code'],
            'source_airport_id' => $validatedData['source_airport_id'],
            'destination_airport_iata_code' => $validatedData['destination_airport_iata_code'],
            'destination_airport_id' => $validatedData['destination_airport_id'],
            'number_of_stops' => $validatedData['number_of_stops'],
            'equipment' => $validatedData['equipment']
        ]);

        // Save the new Flightdata instance to the database
        $flightdata->save();

        // Return a response indicating success
        return response()->json(['message' => 'Flight data saved successfully'], 201);
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        try {
            $flightdata = Flightdata::findOrFail($id);
        } catch (ModelNotFoundException $e) {
            return response()->json([
                'message' => 'Record not found'
            ], 404);
        }

        return response()->json($flightdata);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
}

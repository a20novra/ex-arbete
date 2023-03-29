<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Flightdata extends Model
{
    use HasFactory;
    protected $fillable = ['airline_iata_code', 'airline_id', 'source_airport_iata_code', 'source_airport_id','destination_airport_iata_code', 'destination_airport_id', 'number_of_stops', 'equipment'];

}

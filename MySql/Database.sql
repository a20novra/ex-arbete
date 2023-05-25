DROP DATABASE flygdata;
CREATE DATABASE flygdata;
USE flygdata;

CREATE TABLE flightdatas (
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	airline_iata_code CHAR(3),
	airline_id INT(6),
	source_airport_iata_code CHAR(4),
	source_airport_id INT(6),
	destination_airport_iata_code CHAR(4),
	destination_airport_id INT(6),
	number_of_stops INT(6),
	equipment VARCHAR(32),
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB;

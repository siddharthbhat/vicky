package com.ee417.website.group.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ee417.website.group.models.TemperatureSensor;
import com.ee417.website.group.service.TemperatureSensorService;


/**
 * @author Peter Staunton
 * @date 09/04/2024
 * @category controller
 * Provides link from clients in front-end to server-side logic
 */
@RestController
@RequestMapping("/temperature")
@CrossOrigin(origins = "*") // Allows requests from other domains. Adjust or remove based on security requirements.
public class TemperatureSensorController {
	@Autowired
    private TemperatureSensorService service;

    // GET endpoint to retrieve all temperature sensor readings.
	@GetMapping
//	@CrossOrigin(origins = "*")
    public ResponseEntity<List<TemperatureSensor>> getAllTemperatureSensorReadings() {
    	System.out.println("POST request received for TemperatureSensor.");
        List<TemperatureSensor> readings = service.findAll();
        return new ResponseEntity<>(readings, HttpStatus.OK);
    }
    
    // GET endpoint to retrieve a specific temperature sensor reading by a room id number.
    @GetMapping("/room/{name}")
//    @CrossOrigin(origins = "*")
    public ResponseEntity<List<TemperatureSensor>> getTemperatureSensorReadingById(@PathVariable String name) {
    	System.out.println("GET request received for EnergyUsage - name.");
        List<TemperatureSensor> reading = service.findByName(name);
        return new ResponseEntity<>(reading, HttpStatus.OK);
    }
    
    // Endpoint to get records by time frame: last 24 hours or last 7 days
    @GetMapping("/time")
//    @CrossOrigin(origins = "*")
    public ResponseEntity<List<TemperatureSensor>> getReadingsByTimeFrame(@RequestParam(required = false) String timeFrame) {
    	System.out.println("POST request received for TemperatureSensor - time.");
        List<TemperatureSensor> readings;
        if ("last24Hours".equals(timeFrame)) {
            readings = service.findLast24Hours();
        } else if ("last7Days".equals(timeFrame)) {
            readings = service.findLast7Days();
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(readings, HttpStatus.OK);
    }

    // POST endpoint to create a new temperature sensor reading.
    @PostMapping
//	@CrossOrigin(origins = "*")
    public ResponseEntity<TemperatureSensor> createTemperatureSensorReading(@RequestBody TemperatureSensor sensor) {
    	System.out.println("POST request received for TemperatureSensor.");
    	TemperatureSensor newReading = service.addRecording(sensor);
        return new ResponseEntity<>(newReading, HttpStatus.CREATED);
    }
}
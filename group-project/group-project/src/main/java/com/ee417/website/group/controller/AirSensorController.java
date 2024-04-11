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

import com.ee417.website.group.entity.AirSensorEntity;
import com.ee417.website.group.models.AirSensor;
import com.ee417.website.group.service.AirSensorService;

/**
 * @author Peter Staunton
 * @date 08/04/2024
 * @category controller
 * Provides link from clients in front-end to server-side logic
 */
@RestController
@RequestMapping("/air")
@CrossOrigin(origins = "*") // Allows requests from other domains. Adjust or remove based on security requirements.
public class AirSensorController {
	@Autowired
    private AirSensorService airSensorService;

    // GET endpoint to retrieve all air sensor readings.
    @GetMapping("*")
    public ResponseEntity<List<AirSensor>> getAllAirSensorReadings() {
    	System.out.println("POST request received for AirSensor.");
        List<AirSensor> readings = airSensorService.findAll();
        return new ResponseEntity<>(readings, HttpStatus.OK);
    }

    // GET endpoint to retrieve a specific air sensor reading by a room id number.
    @GetMapping("/room/{name}")
    public ResponseEntity<List<AirSensor>> getAirSensorReadingById(@PathVariable String name) {
    	System.out.println("POST request received for AirSensor - name.");
        List<AirSensor> reading = airSensorService.findByName(name);
        return new ResponseEntity<>(reading, HttpStatus.OK);
    }
    
    // Endpoint to get records by time frame: last 24 hours or last 7 days
    @GetMapping("/time")
    public ResponseEntity<List<AirSensorEntity>> getReadingsByTimeFrame(@RequestParam(required = false) String timeFrame) {
    	System.out.println("POST request received for AirSensor - time.");
        List<AirSensorEntity> readings;
        if ("last24Hours".equals(timeFrame)) {
            readings = airSensorService.findLast24Hours();
        } else if ("last7Days".equals(timeFrame)) {
            readings = airSensorService.findLast7Days();
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(readings, HttpStatus.OK);
    }

    // POST endpoint to create a new air sensor reading.
    @PostMapping
    public ResponseEntity<AirSensor> createAirSensorReading(@RequestBody AirSensor sensor) {
    	System.out.println("POST request received for AirSensor.");
        AirSensor newReading = airSensorService.addRecording(sensor);
        return new ResponseEntity<>(newReading, HttpStatus.CREATED);
    }
}

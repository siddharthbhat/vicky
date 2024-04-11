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

import com.ee417.website.group.models.HumiditySensor;
import com.ee417.website.group.service.HumiditySensorService;

/**
 * @author Peter Staunton
 * @date 09/04/2024
 * @category controller
 * Provides link from clients in front-end to server-side logic
 */
@RestController
@RequestMapping("/humidity")
@CrossOrigin(origins = "*") // Allows requests from other domains. Adjust or remove based on security requirements.
public class HumiditySensorController {
	@Autowired
    private HumiditySensorService service;

    // GET endpoint to retrieve all humidity sensor readings.
    @GetMapping
    public ResponseEntity<List<HumiditySensor>> getAllHumiditySensorReadings() {
    	System.out.println("POST request received for HumiditySensor.");
        List<HumiditySensor> readings = service.findAll();
        return new ResponseEntity<>(readings, HttpStatus.OK);
    }
    
    // GET endpoint to retrieve a specific humidity sensor reading by a room id number.
    @GetMapping("/room/{name}")
    public ResponseEntity<List<HumiditySensor>> getHumiditySensorReadingById(@PathVariable String name) {
    	System.out.println("GET request received for HumiditySensor - name.");
        List<HumiditySensor> reading = service.findByName(name);
        return new ResponseEntity<>(reading, HttpStatus.OK);
    }
    
    // Endpoint to get records by time frame: last 24 hours or last 7 days
    @GetMapping("/time")
    public ResponseEntity<List<HumiditySensor>> getReadingsByTimeFrame(@RequestParam(required = false) String timeFrame) {
    	System.out.println("POST request received for HumiditySensor - time.");
        List<HumiditySensor> readings;
        if ("last24Hours".equals(timeFrame)) {
            readings = service.findLast24Hours();
        } else if ("last7Days".equals(timeFrame)) {
            readings = service.findLast7Days();
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(readings, HttpStatus.OK);
    }

    // POST endpoint to create a new humidity sensor reading.
    @PostMapping
    public ResponseEntity<HumiditySensor> createHumiditySensorReading(@RequestBody HumiditySensor usage) {
    	System.out.println("POST request received for HumiditySensor.");
    	HumiditySensor newReading = service.addRecording(usage);
        return new ResponseEntity<>(newReading, HttpStatus.CREATED);
    }
}
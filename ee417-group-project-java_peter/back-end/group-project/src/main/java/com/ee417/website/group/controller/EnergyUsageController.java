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

import com.ee417.website.group.models.EnergyUsage;
import com.ee417.website.group.service.EnergyUsageService;

/**
 * @author Peter Staunton
 * @date 08/04/2024
 * @category controller
 * Provides link from clients in front-end to server-side logic
 */
@RestController
@RequestMapping("/energy")
@CrossOrigin(origins = "*") // Allows requests from other domains. Adjust or remove based on security requirements.
public class EnergyUsageController {
	@Autowired
    private EnergyUsageService energyService;

    // GET endpoint to retrieve all energy usage readings.
    @GetMapping
    public ResponseEntity<List<EnergyUsage>> getAllEnergyUsageReadings() {
    	System.out.println("POST request received for AirSensor.");
        List<EnergyUsage> readings = energyService.findAll();
        return new ResponseEntity<>(readings, HttpStatus.OK);
    }
    
    // GET endpoint to retrieve a specific energy usage reading by a room id number.
    @GetMapping("/room/{name}")
    public ResponseEntity<List<EnergyUsage>> getEnergyUsageReadingById(@PathVariable String name) {
    	System.out.println("POST request received for EnergyUsage - name.");
        List<EnergyUsage> reading = energyService.findByName(name);
        return new ResponseEntity<>(reading, HttpStatus.OK);
    }
    
    // Endpoint to get records by time frame: last 24 hours or last 7 days
    @GetMapping("/time")
    public ResponseEntity<List<EnergyUsage>> getReadingsByTimeFrame(@RequestParam(required = false) String timeFrame) {
    	System.out.println("POST request received for EnergyUsage - time.");
        List<EnergyUsage> readings;
        if ("last24Hours".equals(timeFrame)) {
            readings = energyService.findLast24Hours();
        } else if ("last7Days".equals(timeFrame)) {
            readings = energyService.findLast7Days();
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(readings, HttpStatus.OK);
    }

    // POST endpoint to create a new air sensor reading.
    @PostMapping
    public ResponseEntity<EnergyUsage> createEnergyUsageReading(@RequestBody EnergyUsage usage) {
    	System.out.println("POST request received for EnergyUsage.");
    	EnergyUsage newReading = energyService.addRecording(usage);
        return new ResponseEntity<>(newReading, HttpStatus.CREATED);
    }
}
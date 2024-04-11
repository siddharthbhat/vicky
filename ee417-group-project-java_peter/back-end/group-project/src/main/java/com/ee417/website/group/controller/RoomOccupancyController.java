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

import com.ee417.website.group.models.RoomOccupancy;
import com.ee417.website.group.service.RoomOccupancyService;

/**
 * @author Peter Staunton
 * @date 09/04/2024
 * @category controller
 * Provides link from clients in front-end to server-side logic
 */
@RestController
@RequestMapping("/occupancy")
@CrossOrigin // Allows requests from other domains. Adjust or remove based on security requirements.
public class RoomOccupancyController {
	@Autowired
    private RoomOccupancyService service;

    // GET endpoint to retrieve all room occupancy readings.
    @GetMapping
    public ResponseEntity<List<RoomOccupancy>> getAllRoomOccupancyReadings() {
    	System.out.println("POST request received for RoomOccupancy.");
        List<RoomOccupancy> readings = service.findAll();
        return new ResponseEntity<>(readings, HttpStatus.OK);
    }
    
    // GET endpoint to retrieve a specific room occupancy reading by a room id number.
    @GetMapping("/room/{name}")
    public ResponseEntity<List<RoomOccupancy>> getRoomOccupancyReadingById(@PathVariable String name) {
    	System.out.println("GET request received for RoomOccupancy - name.");
        List<RoomOccupancy> reading = service.findByName(name);
        return new ResponseEntity<>(reading, HttpStatus.OK);
    }
    
    // Endpoint to get records by time frame: last 24 hours or last 7 days
    @GetMapping("/time")
    public ResponseEntity<List<RoomOccupancy>> getReadingsByTimeFrame(@RequestParam(required = false) String timeFrame) {
    	System.out.println("POST request received for RoomOccupancy - time.");
        List<RoomOccupancy> readings;
        if ("last24Hours".equals(timeFrame)) {
            readings = service.findLast24Hours();
        } else if ("last7Days".equals(timeFrame)) {
            readings = service.findLast7Days();
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(readings, HttpStatus.OK);
    }

    // POST endpoint to create a new room occupancy reading.
    @PostMapping
    public ResponseEntity<RoomOccupancy> createAirSensorReading(@RequestBody RoomOccupancy usage) {
    	System.out.println("POST request received for RoomOccupancy.");
    	RoomOccupancy newReading = service.addRecording(usage);
        return new ResponseEntity<>(newReading, HttpStatus.CREATED);
    }
}
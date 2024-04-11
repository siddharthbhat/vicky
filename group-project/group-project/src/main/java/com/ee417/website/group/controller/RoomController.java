package com.ee417.website.group.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ee417.website.group.models.Room;
import com.ee417.website.group.service.RoomService;

/**
 * @author Peter Staunton
 * @date 08/04/2024
 * @category controller
 * Provides link from clients in front-end to server-side logic
 */
@RestController
@RequestMapping("/room")
@CrossOrigin(origins = "*") // allows requests from any domain
public class RoomController {
	@Autowired
	private RoomService service;
	
	// GET endpoint to retrieve all rooms in db.
    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
    	System.out.println("GET request received for Room.");
    	List<Room> rooms = service.listRooms();
    	return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
    
 // POST endpoint to create a new room in db.
    @PostMapping
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
    	System.out.println("POST request received for Room.");
    	Room newRoom = service.addRoom(room);
    	return new ResponseEntity<>(newRoom, HttpStatus.CREATED);
    }
}

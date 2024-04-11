package com.ee417.website.group.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Peter Staunton
 * @date 06/04/2024
 * @category model
 * Provides object to interact with clients
 */
public class Room {
	private long id; // room_id for db
	private String name; // Room name/code eg. SA143
	private int capacity; // Room capacity eg. 40, 140 etc
	private String building; // building eg. Stokes
	
	// Default constructor room(room name, room capacity)
	public Room(long id, String name, int capacity, String building) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.building = building;
	}
	
	// No arg constructor for mapping
	public Room() {}
	
    // Constructor that takes an ID of type long
    @JsonCreator
    public Room(@JsonProperty("id") long id) {
        this.id = id;
        // Initialize or fetch the Room instance based on the ID
    }
	
	// Constructor with just room name
	public Room(String name) {
		this(0, name, 0, ""); // sets capacity to 0 if none entered
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}	
}

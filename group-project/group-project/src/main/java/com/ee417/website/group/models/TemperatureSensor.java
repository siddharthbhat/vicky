package com.ee417.website.group.models;

import java.time.LocalDateTime;

/**
 * @author Peter Staunton
 * @date 06/04/2024
 * @category model
 * Provides object to interact with clients
 */
public class TemperatureSensor {
	private Long id;
	private LocalDateTime timeDate; // recording time
	private Room room; // recording location
	private Long roomId; // room id for easier json parsing
	double temperature; // degrees C
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDateTime getTimeDate() {
		return timeDate;
	}
	
	public void setTimeDate(LocalDateTime timeDate) {
		this.timeDate = timeDate;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		setRoomId(room.getId());
		this.room = room;
	}
	
	public Long getRoomId() {
		return roomId;
	}
	
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	
	public double getTemperature() {
		return temperature;
	}
	
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
		
}

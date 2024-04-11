package com.ee417.website.group.models;

import java.time.LocalDateTime;


/**
 * @author Peter Staunton
 * @date 07/04/2024
 * @category model
 * Java class to receive/send sensor objects to client
 */

public class HumiditySensor {
	private Long id;
	private LocalDateTime timeDate; // recording time
    private Room room; // recording location
    private long roomId;
	private double humidity;
	
	public HumiditySensor(Long id, LocalDateTime timeDate, long roomId, double humidity) {
		super();
		this.id = id;
		this.timeDate = timeDate;
//		this.room = room;
		this.roomId = roomId;
		this.humidity = humidity;
	}
	
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
		setRoomId(room.getId()); // updates room id based on room parameters
		this.room = room;
	}
	
	public Long getRoomId() {
		return this.roomId;
	}
	
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	
	public double getHumidity() {
		return humidity;
	}
	
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	
}

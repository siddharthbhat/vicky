package com.ee417.website.group.models;

import java.time.LocalDateTime;

/**
 * @author Peter Staunton
 * @date 06/04/2024
 * @category model
 * Provides object to interact with clients
 */
public class NoiseSensor {
	private long id;
	private LocalDateTime timeDate; // recording time
	private Room room; // place recording took place
	private Long roomId; // used to reference for model input
	private double noiseLevelDB ; // noise level
	
	/**
	 * @param id, timeDate, room, noiseLevelDB
	 */
	public NoiseSensor(long id, LocalDateTime timeDate, Long roomId, double noiseLevelDB) {
		super();
		this.id = id;
		this.timeDate = timeDate;
		this.roomId = roomId;
		this.noiseLevelDB = noiseLevelDB;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
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
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public double getNoiseLevelDB() {
		return noiseLevelDB;
	}
	
	public void setNoiseLevelDB(double noiseLevelDB) {
		this.noiseLevelDB = noiseLevelDB;
	}
}

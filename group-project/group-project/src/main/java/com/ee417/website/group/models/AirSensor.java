package com.ee417.website.group.models;

import java.time.LocalDate;

/**
 * @author Peter Staunton
 * @date 06/04/2024
 * @category model
 * Provides object to interact with clients
 */
public class AirSensor {
	private long id;
	private LocalDate timeDate; // recording time
	private Room room; // id + capacity
	private long roomId; // use id directly for parsing json
	double air_quality;
	
	public AirSensor() {}
	
//	public AirSensor(long id, Date timeDate, Room room, double air_quality) {
	public AirSensor(long id, LocalDate timeDate, long roomId, double air_quality) {
		this.id = id;
		this.timeDate = timeDate;
//		this.room = room;
		this.roomId = roomId;
		this.air_quality = air_quality;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getTimeDate() {
		return timeDate;
	}

	public void setTimeDate(LocalDate timeDate) {
		this.timeDate = timeDate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		setRoomId(room.getId()); // updates separate roomId field
		this.room = room;
	}
	
	public double getAir_quality() {
		return air_quality;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public void setAir_quality(double air_quality) {
		this.air_quality = air_quality;
	}	
}

package com.ee417.website.group.models;

import java.time.LocalDateTime;

/**
 * @author Peter Staunton
 * @date 06/04/2024
 * @category model
 * Provides object to interact with clients
 */
public class RoomOccupancy {
	private Long id;
	private LocalDateTime timeDate; // recording time
	private Long roomId; // FK: Room's id
	private Room room; // room to derive capacity and contains room id
	private int currentOccupancy; // Recorded number of people in room
	private double percentOccupancy;
	
	public RoomOccupancy(long id, LocalDateTime timeDate, Long roomId, int currentOccupancy) {
		this.id = id;
		this.timeDate = timeDate;
		this.roomId = roomId;
		this.currentOccupancy = currentOccupancy;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDateTime getTimeDate() {
		return this.timeDate;
	}
	
	public void setTimeDate(LocalDateTime timeDate) {
		this.timeDate = timeDate;
	}
	
	public Room getRoom() {
		return this.room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
		setPercentOccupancy(); // updates value if room changes
		setRoomId(room.getId());
	}
		
	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public int getCurrentOccupancy() {
		return currentOccupancy;
	}

	public void setCurrentOccupancy(int currentOccupancy) {
		this.currentOccupancy = currentOccupancy;
	}

	public double getPercentOccupancy() {
		return this.percentOccupancy;
	}
	
	// Updates % based on room occupancy/capacity
	private void setPercentOccupancy() {
		int capacity = room.getCapacity();
		this.percentOccupancy = 100.0*currentOccupancy/capacity; // updates value, 100.0 should ensure cast to double				
	}
	
}

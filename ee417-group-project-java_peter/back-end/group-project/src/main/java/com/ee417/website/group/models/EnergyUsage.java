package com.ee417.website.group.models;

import java.time.LocalDateTime;

/**
 * @author Peter Staunton
 * @date 06/04/2024
 * @category model
 * Provides object to interact with clients
 */
public class EnergyUsage {
	private long id;
	private LocalDateTime timeDate; // recording time
	private Room room;
	private Long roomId;
	private int energyUsage;
	
	public EnergyUsage(long id, LocalDateTime timeDate, Long roomId, int energyUsage) {
		this.id = id;
		this.timeDate = timeDate;
		this.setRoomId(roomId);
		this.energyUsage = energyUsage;
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
		setRoomId(room.getId()); // updates separate roomId field
		this.room = room;
	}

	
	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public int getEnergyUsage() {
		return energyUsage;
	}

	public void setEnergyUsage(int energyUsage) {
		this.energyUsage = energyUsage;
	}

}

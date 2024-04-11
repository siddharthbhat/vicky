package com.ee417.website.group.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * @author Peter Staunton
 * @date 08/04/2024
 * @category entity
 * Provides link to sensor table in db
 */
@Entity(name = "roomoccupancy")
public class RoomOccupancyEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime timeDate; // recording time
    @ManyToOne
    @JoinColumn(name = "room_id") // This column in noisesensor table will reference the primary key of room table.
    private RoomEntity room;
    private int currentOccupancy;
    private double percentOccupancy;
    
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
	
	public RoomEntity getRoom() {
		return room;
	}
	
	public void setRoom(RoomEntity room) {
		this.room = room;
	}
	
	public int getCurrentOccupancy() {
		return currentOccupancy;
	}
	
	public void setCurrentOccupancy(int currentOccupancy) {
		this.currentOccupancy = currentOccupancy;
	}
	
	public double getPercentOccupancy() {
		return percentOccupancy;
	}
	
	public void setPercentOccupancy() {
		int capacity = room.getCapacity();
		this.percentOccupancy = 100.0*currentOccupancy/capacity; // updates value, 100.0 should ensure cast to double		
	}

	@Override
	public int hashCode() {
		return Objects.hash(currentOccupancy, id, percentOccupancy, room, timeDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoomOccupancyEntity other = (RoomOccupancyEntity) obj;
		return currentOccupancy == other.currentOccupancy && id == other.id
				&& Double.doubleToLongBits(percentOccupancy) == Double.doubleToLongBits(other.percentOccupancy)
				&& Objects.equals(room, other.room) && Objects.equals(timeDate, other.timeDate);
	}

	@Override
	public String toString() {
		return "RoomOccupancyEntity [id=" + id + ", timeDate=" + timeDate + ", room=" + room + ", currentOccupancy="
				+ currentOccupancy + ", percentOccupancy=" + percentOccupancy + "]";
	}
	
	
}

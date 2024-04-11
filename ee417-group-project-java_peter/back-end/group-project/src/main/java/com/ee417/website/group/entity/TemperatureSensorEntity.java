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
 * @date 07/04/2024
 * @category entity
 * Provides link to sensor table in db
 */
@Entity(name = "temperaturesensor")
public class TemperatureSensorEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime timeDate; // recording time
    @ManyToOne
    @JoinColumn(name = "room_id") // This column in temperaturesensor table will reference the primary key of room table.
    private RoomEntity room;
	private double temperature;
	
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
	
	public double getTemperature() {
		return temperature;
	}
	
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, room, temperature, timeDate);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TemperatureSensorEntity other = (TemperatureSensorEntity) obj;
		return id == other.id && Objects.equals(room, other.room)
				&& Double.doubleToLongBits(temperature) == Double.doubleToLongBits(other.temperature)
				&& Objects.equals(timeDate, other.timeDate);
	}
	
	@Override
	public String toString() {
		return "TemperatureSensorEntity [id=" + id + ", timeDate=" + timeDate + ", room=" + room + ", temperature=" + temperature
				+ "]";
	}
}

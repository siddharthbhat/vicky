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
@Entity(name = "humiditysensor")
public class HumiditySensorEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime timeDate;
    @ManyToOne
    @JoinColumn(name = "room_id") // This column in humiditysensor table will reference the primary key of room table.
	private RoomEntity room;
	private double humidity;
	
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
	
	public double getHumidity() {
		return humidity;
	}
	
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(humidity, id, room, timeDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HumiditySensorEntity other = (HumiditySensorEntity) obj;
		return Double.doubleToLongBits(humidity) == Double.doubleToLongBits(other.humidity) && id == other.id
				&& Objects.equals(room, other.room) && Objects.equals(timeDate, other.timeDate);
	}

	@Override
	public String toString() {
		return "HumiditySensorEntity [id=" + id + ", timeDate=" + timeDate + ", room=" + room + ", humidity="
				+ humidity + "]";
	}
	
}

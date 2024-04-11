package com.ee417.website.group.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "airsensor")
public class AirSensorEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime  timeDate;
    @ManyToOne
    @JoinColumn(name = "room_id") // This column in airsensor table will reference the primary key of room table.
	private RoomEntity room;
	double air_quality;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDateTime  getTimeDate() {
		return timeDate;
	}
	
	public void settimeDate(LocalDateTime  timeDate) {
		this.timeDate = timeDate;
	}
	
	public RoomEntity getRoom() {
		return room;
	}
	
	public void setRoom(RoomEntity room) {
		this.room = room;
	}
	
	public double getAir_quality() {
		return air_quality;
	}

	public void setAir_quality(double air_quality) {
		this.air_quality = air_quality;
	}

	@Override
	public int hashCode() {
		return Objects.hash(air_quality, id, room, timeDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirSensorEntity other = (AirSensorEntity) obj;
		return Double.doubleToLongBits(air_quality) == Double.doubleToLongBits(other.air_quality) && id == other.id
				&& Objects.equals(room, other.room) && Objects.equals(timeDate, other.timeDate);
	}

	@Override
	public String toString() {
		return "AirSensorEntity [id=" + id + ", timeDate=" + timeDate + ", room=" + room + ", air_quality="
				+ air_quality + "]";
	}
}
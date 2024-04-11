package com.ee417.website.group.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author Peter Staunton
 * @date 07/04/2024
 * @category entity
 * Provides link to room table in db
 */
@Entity(name = "room")
public class RoomEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int capacity;
	private String building;
	
	public RoomEntity() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	@Override
	public int hashCode() {
		return Objects.hash(building, capacity, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoomEntity other = (RoomEntity) obj;
		return Objects.equals(building, other.building) && capacity == other.capacity && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", capacity=" + capacity + ", building=" + building + "]";
	}
	
	

}

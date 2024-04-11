package com.ee417.website.group.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ee417.website.group.entity.RoomEntity;

/**
 * @author Peter Staunton
 * @date 07/04/24
 * @category repository
 * Provides interface for accessing room entities in the db
 */
public interface RoomEntityRepository extends JpaRepository<RoomEntity, Long> {
	List<RoomEntity> findRoomsByBuilding(String building); // list of rooms in a building
	Optional<RoomEntity> findRoomByName(String name); // returns room object with name
}

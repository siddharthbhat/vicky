package com.ee417.website.group.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ee417.website.group.entity.RoomOccupancyEntity;

/**
 * @author Peter Staunton
 * @date 0/04/24
 * @category repository
 * Provides interface for accessing room occupancy entities in the db
 */
@Repository
public interface RoomOccupancyRepository extends JpaRepository<RoomOccupancyEntity, Long> {
	List<RoomOccupancyEntity> findByRoom_Name(String name);  // returns a list of recordings for a room
	List<RoomOccupancyEntity> findByTimeDate(Date timeDate);  // returns list of recordings by date
	List<RoomOccupancyEntity> findByTimeDateAfter(LocalDateTime dateTime); // returns all recordings since date
}
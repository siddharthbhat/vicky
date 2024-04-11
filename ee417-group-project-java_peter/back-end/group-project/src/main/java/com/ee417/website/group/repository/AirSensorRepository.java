package com.ee417.website.group.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ee417.website.group.entity.AirSensorEntity;

/**
 * @author Peter Staunton
 * @date 07/04/24
 * @category repository
 * Provides interface for accessing air sensor entities in the db
 */
@Repository
public interface AirSensorRepository extends JpaRepository<AirSensorEntity, Long> {
	List<AirSensorEntity> findByRoom_Name(String name);  // returns a list of recordings for a room
	List<AirSensorEntity> findByTimeDate(LocalDateTime timeDate);  // returns list of recordings by date
	List<AirSensorEntity> findByTimeDateAfter(LocalDateTime dateTime); // returns all recordings since date
}

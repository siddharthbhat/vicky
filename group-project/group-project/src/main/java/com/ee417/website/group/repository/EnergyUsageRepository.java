package com.ee417.website.group.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ee417.website.group.entity.EnergyUsageEntity;

/**
 * @author Peter Staunton
 * @date 07/04/24
 * @category repository
 * Provides interface for accessing energy usage entities in the db
 */
@Repository
public interface EnergyUsageRepository extends JpaRepository<EnergyUsageEntity, Long> {
	List<EnergyUsageEntity> findByRoom_Name(String name); // returns a list of recordings for a room
	List<EnergyUsageEntity> findByTimeDate(Date timeDate); // returns list of recordings by date
	List<EnergyUsageEntity> findByTimeDateAfter(LocalDateTime dateTime); // returns all recordings since date
}

package com.ee417.website.group.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ee417.website.group.entity.RoomOccupancyEntity;
import com.ee417.website.group.entity.RoomEntity;
import com.ee417.website.group.mapper.RoomOccupancyMapper;
import com.ee417.website.group.mapper.RoomMapper;
import com.ee417.website.group.models.RoomOccupancy;
import com.ee417.website.group.repository.RoomOccupancyRepository;
import com.ee417.website.group.repository.RoomEntityRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * @author Peter Staunton
 * @date 09/04/2024
 * @category service
 * Provides performs server-side logic for controller
 */
@Service
public class RoomOccupancyService {
	@Autowired
	private final RoomOccupancyRepository occupancyRepository;
	@Autowired
	private final RoomEntityRepository roomRepository;
	@Autowired
	private final RoomOccupancyMapper occupancyMapper;
	@Autowired
	private final RoomMapper roomMapper;

	public RoomOccupancyService(RoomOccupancyRepository occupancyRepository, RoomEntityRepository roomRepository,
			RoomOccupancyMapper occupancyMapper, RoomMapper roomMapper) {
		this.occupancyRepository = occupancyRepository;
		this.roomRepository = roomRepository;
		this.occupancyMapper = occupancyMapper;
		this.roomMapper = roomMapper;
	}

	// Retrieves list of all sensor recordings as entities -> maps to an list of models and returns to client
	public List<RoomOccupancy> findAll() {
		List<RoomOccupancyEntity> entityList = occupancyRepository.findAll();
		return occupancyMapper.mapList(entityList);
	}

	public List<RoomOccupancy> findByName(String name) {
	    List<RoomOccupancyEntity> entityList = occupancyRepository.findByRoom_Name(name); // Fetch the entities based on the room name
	    // Check if the entityList is empty and throw an exception if so.
	    if (entityList.isEmpty()) {
	        throw new RuntimeException("Room not found");
	    }
	    return occupancyMapper.mapList(entityList); // maps list back to a model and sends to controller
	}
	
    // Use LocalDateTime to find readings after a certain date
    public List<RoomOccupancy> findByTimeDateAfter(LocalDateTime dateTime) {
    	List<RoomOccupancyEntity> entityList = occupancyRepository.findByTimeDateAfter(dateTime);
        return occupancyMapper.mapList(entityList); // returns list as EnergyUsage model
    }

    // Find readings from the last 24 hours
    public List<RoomOccupancy> findLast24Hours() {
        LocalDateTime dateTime = LocalDateTime.now().minusHours(24);
        return findByTimeDateAfter(dateTime);
    }

    // Method to find readings from the last 7 days
    public List<RoomOccupancy> findLast7Days() {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(7);
        return findByTimeDateAfter(dateTime);
    }

    // POST new sensor recording
	public RoomOccupancy addRecording(@Valid @NotNull RoomOccupancy occupancyModel) {
		RoomEntity room = roomRepository.findById(occupancyModel.getRoomId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found")); // checks for existence of room in db
	    occupancyModel.setRoom(roomMapper.entityToDto(room)); // converts to room model and adds referenced room to occupancyModel
	    	
	    RoomOccupancyEntity sensorEntity = occupancyMapper.dtoToEntity(occupancyModel); // converts received model -> entity
	    // If time is not provided, default to the current time
	    if (sensorEntity.getTimeDate() == null) {
	        sensorEntity.setTimeDate(LocalDateTime.now());
	    }
		
		occupancyRepository.save(sensorEntity); // saves to db
		
		return occupancyMapper.entityToDto(sensorEntity); // returns model back if successful
	}	
}
package com.ee417.website.group.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ee417.website.group.entity.NoiseSensorEntity;
import com.ee417.website.group.entity.RoomEntity;
import com.ee417.website.group.mapper.NoiseSensorMapper;
import com.ee417.website.group.mapper.RoomMapper;
import com.ee417.website.group.models.NoiseSensor;
import com.ee417.website.group.repository.NoiseSensorRepository;
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
public class NoiseSensorService {
	@Autowired
	private final NoiseSensorRepository sensorRepository;
	@Autowired
	private final RoomEntityRepository roomRepository;
	@Autowired
	private final NoiseSensorMapper sensorMapper;
	@Autowired
	private final RoomMapper roomMapper;

	public NoiseSensorService(NoiseSensorRepository sensorRepository, RoomEntityRepository roomRepository,
			NoiseSensorMapper sensorMapper, RoomMapper roomMapper) {
		this.sensorRepository = sensorRepository;
		this.roomRepository = roomRepository;
		this.sensorMapper = sensorMapper;
		this.roomMapper = roomMapper;
	}

	// Retrieves list of all sensor recordings as entities -> maps to an list of models and returns to client
	public List<NoiseSensor> findAll() {
		List<NoiseSensorEntity> entityList = sensorRepository.findAll();
		return sensorMapper.mapList(entityList);
	}

	public List<NoiseSensor> findByName(String name) {
	    List<NoiseSensorEntity> entityList = sensorRepository.findByRoom_Name(name); // Fetch the entities based on the room name
	    // Check if the entityList is empty and throw an exception if so.
	    if (entityList.isEmpty()) {
	        throw new RuntimeException("Room not found");
	    }
	    return sensorMapper.mapList(entityList); // maps list back to a model and sends to controller
	}
	
    // Use LocalDateTime to find readings after a certain date
    public List<NoiseSensor> findByTimeDateAfter(LocalDateTime dateTime) {
    	List<NoiseSensorEntity> entityList = sensorRepository.findByTimeDateAfter(dateTime);
        return sensorMapper.mapList(entityList); // returns list as EnergyUsage model
    }

    // Find readings from the last 24 hours
    public List<NoiseSensor> findLast24Hours() {
        LocalDateTime dateTime = LocalDateTime.now().minusHours(24);
        return findByTimeDateAfter(dateTime);
    }

    // Method to find readings from the last 7 days
    public List<NoiseSensor> findLast7Days() {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(7);
        return findByTimeDateAfter(dateTime);
    }

    // POST new sensor recording
	public NoiseSensor addRecording(@Valid @NotNull NoiseSensor sensorModel) {
		RoomEntity room = roomRepository.findById(sensorModel.getRoomId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found")); // checks for existence of room in db
	    sensorModel.setRoom(roomMapper.entityToDto(room)); // converts to room model and adds referenced room to sensorModel
	    	
	    NoiseSensorEntity sensorEntity = sensorMapper.dtoToEntity(sensorModel); // converts received model -> entity
	    // If time is not provided, default to the current time
	    if (sensorEntity.getTimeDate() == null) {
	        sensorEntity.setTimeDate(LocalDateTime.now());
	    }
		
		sensorRepository.save(sensorEntity); // saves to db
		
		return sensorMapper.entityToDto(sensorEntity); // returns model back if successful
	}	
}
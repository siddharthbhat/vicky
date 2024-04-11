package com.ee417.website.group.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ee417.website.group.entity.AirSensorEntity;
import com.ee417.website.group.entity.RoomEntity;
import com.ee417.website.group.mapper.AirSensorMapper;
import com.ee417.website.group.mapper.RoomMapper;
import com.ee417.website.group.models.AirSensor;
import com.ee417.website.group.repository.AirSensorRepository;
import com.ee417.website.group.repository.RoomEntityRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * @author Peter Staunton
 * @date 08/04/2024
 * @category service
 * Provides performs server-side logic for controller
 */
@Service
public class AirSensorService {
	@Autowired
	private final AirSensorRepository sensorRepository;
	@Autowired
	private final RoomEntityRepository roomRepository;
	@Autowired
	private final AirSensorMapper sensorMapper;
	@Autowired
	private final RoomMapper roomMapper;

	public AirSensorService(AirSensorRepository sensorRepository, RoomEntityRepository roomRepository,
			AirSensorMapper sensorMapper, RoomMapper roomMapper) {
		this.sensorRepository = sensorRepository;
		this.roomRepository = roomRepository;
		this.sensorMapper = sensorMapper;
		this.roomMapper = roomMapper;
	}

	// Retrieves list of all sensor recordings as entities -> maps to an list of models and returns to client
	public List<AirSensor> findAll() {
		List<AirSensorEntity> entityList = sensorRepository.findAll();
		return sensorMapper.mapList(entityList);
	}

	public List<AirSensor> findByName(String name) {
	    List<AirSensorEntity> entityList = sensorRepository.findByRoom_Name(name); // Fetch the entities based on the room name
	    // Check if the entityList is empty and throw an exception if so.
	    if (entityList.isEmpty()) {
	        throw new RuntimeException("Room not found");
	    }
	    return sensorMapper.mapList(entityList); // maps list back to a model and sends to controller
	}
	
    // Use LocalDateTime to find readings after a certain date
    public List<AirSensorEntity> findByTimeDateAfter(LocalDateTime dateTime) {
        return sensorRepository.findByTimeDateAfter(dateTime);
    }

    // Find readings from the last 24 hours
    public List<AirSensorEntity> findLast24Hours() {
        LocalDateTime dateTime = LocalDateTime.now().minusHours(24);
        return findByTimeDateAfter(dateTime);
    }

    // Method to find readings from the last 7 days
    public List<AirSensorEntity> findLast7Days() {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(7);
        return findByTimeDateAfter(dateTime);
    }

    // POST new sensor recording
	public AirSensor addRecording(@Valid @NotNull AirSensor sensorModel) {
		RoomEntity room = roomRepository.findById(sensorModel.getRoomId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found"));

	    sensorModel.setRoom(roomMapper.entityToDto(room)); // converts to room model and adds to sensorModel
	    	
		AirSensorEntity sensorEntity = sensorMapper.dtoToEntity(sensorModel); // converts received model -> entity
	    // If time is not provided, default to the current time
	    if (sensorEntity.getTimeDate() == null) {
	        sensorEntity.settimeDate(LocalDateTime.now());
	    }
		
		sensorRepository.save(sensorEntity); // saves to db
		
		return sensorMapper.entityToDto(sensorEntity); // returns model back if successful
	}	
}

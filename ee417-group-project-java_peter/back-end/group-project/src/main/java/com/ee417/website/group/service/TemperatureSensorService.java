package com.ee417.website.group.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ee417.website.group.entity.TemperatureSensorEntity;
import com.ee417.website.group.entity.RoomEntity;
import com.ee417.website.group.mapper.TemperatureMapper;
import com.ee417.website.group.mapper.RoomMapper;
import com.ee417.website.group.models.TemperatureSensor;
import com.ee417.website.group.repository.TemperatureSensorRepository;
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
public class TemperatureSensorService {
	@Autowired
	private final TemperatureSensorRepository sensorRepository;
	@Autowired
	private final RoomEntityRepository roomRepository;
	@Autowired
	private final TemperatureMapper sensorMapper;
	@Autowired
	private final RoomMapper roomMapper;

	public TemperatureSensorService(TemperatureSensorRepository sensorRepository, RoomEntityRepository roomRepository,
			TemperatureMapper sensorMapper, RoomMapper roomMapper) {
		this.sensorRepository = sensorRepository;
		this.roomRepository = roomRepository;
		this.sensorMapper = sensorMapper;
		this.roomMapper = roomMapper;
	}

	// Retrieves list of all sensor recordings as entities -> maps to an list of models and returns to client
	public List<TemperatureSensor> findAll() {
		List<TemperatureSensorEntity> entityList = sensorRepository.findAll();
		return sensorMapper.mapList(entityList);
	}

	public List<TemperatureSensor> findByName(String name) {
	    List<TemperatureSensorEntity> entityList = sensorRepository.findByRoom_Name(name); // Fetch the entities based on the room name
	    // Check if the entityList is empty and throw an exception if so.
	    if (entityList.isEmpty()) {
	        throw new RuntimeException("Room not found");
	    }
	    return sensorMapper.mapList(entityList); // maps list back to a model and sends to controller
	}
	
    // Use LocalDateTime to find readings after a certain date
    public List<TemperatureSensor> findByTimeDateAfter(LocalDateTime dateTime) {
    	List<TemperatureSensorEntity> entityList = sensorRepository.findByTimeDateAfter(dateTime);
        return sensorMapper.mapList(entityList); // returns list as EnergyUsage model
    }

    // Find readings from the last 24 hours
    public List<TemperatureSensor> findLast24Hours() {
        LocalDateTime dateTime = LocalDateTime.now().minusHours(24);
        return findByTimeDateAfter(dateTime);
    }

    // Method to find readings from the last 7 days
    public List<TemperatureSensor> findLast7Days() {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(7);
        return findByTimeDateAfter(dateTime);
    }

    // POST new sensor recording
	public TemperatureSensor addRecording(@Valid @NotNull TemperatureSensor sensorModel) {
		RoomEntity room = roomRepository.findById(sensorModel.getRoomId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found")); // checks for existence of room in db
	    sensorModel.setRoom(roomMapper.entityToDto(room)); // converts to room model and adds referenced room to sensorModel
	    	
	    TemperatureSensorEntity sensorEntity = sensorMapper.dtoToEntity(sensorModel); // converts received model -> entity
	    // If time is not provided, default to the current time
	    if (sensorEntity.getTimeDate() == null) {
	        sensorEntity.setTimeDate(LocalDateTime.now());
	    }
		
		sensorRepository.save(sensorEntity); // saves to db
		
		return sensorMapper.entityToDto(sensorEntity); // returns model back if successful
	}	
}
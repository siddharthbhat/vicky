package com.ee417.website.group.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ee417.website.group.entity.EnergyUsageEntity;
import com.ee417.website.group.entity.RoomEntity;
import com.ee417.website.group.mapper.EnergyUsageMapper;
import com.ee417.website.group.mapper.RoomMapper;
import com.ee417.website.group.models.EnergyUsage;
import com.ee417.website.group.repository.EnergyUsageRepository;
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
public class EnergyUsageService {
	@Autowired
	private final EnergyUsageRepository energyRepository;
	@Autowired
	private final RoomEntityRepository roomRepository;
	@Autowired
	private final EnergyUsageMapper energyMapper;
	@Autowired
	private final RoomMapper roomMapper;

	public EnergyUsageService(EnergyUsageRepository energyRepository, RoomEntityRepository roomRepository,
			EnergyUsageMapper energyMapper, RoomMapper roomMapper) {
		this.energyRepository = energyRepository;
		this.roomRepository = roomRepository;
		this.energyMapper = energyMapper;
		this.roomMapper = roomMapper;
	}

	// Retrieves list of all sensor recordings as entities -> maps to an list of models and returns to client
	public List<EnergyUsage> findAll() {
		List<EnergyUsageEntity> entityList = energyRepository.findAll();
		return energyMapper.mapList(entityList);
	}

	public List<EnergyUsage> findByName(String name) {
	    List<EnergyUsageEntity> entityList = energyRepository.findByRoom_Name(name); // Fetch the entities based on the room name
	    // Check if the entityList is empty and throw an exception if so.
	    if (entityList.isEmpty()) {
	        throw new RuntimeException("Room not found");
	    }
	    return energyMapper.mapList(entityList); // maps list back to a model and sends to controller
	}
	
    // Use LocalDateTime to find readings after a certain date
    public List<EnergyUsage> findByTimeDateAfter(LocalDateTime dateTime) {
    	List<EnergyUsageEntity> entityList = energyRepository.findByTimeDateAfter(dateTime);
        return energyMapper.mapList(entityList); // returns list as EnergyUsage model
    }

    // Find readings from the last 24 hours
    public List<EnergyUsage> findLast24Hours() {
        LocalDateTime dateTime = LocalDateTime.now().minusHours(24);
        return findByTimeDateAfter(dateTime);
    }

    // Method to find readings from the last 7 days
    public List<EnergyUsage> findLast7Days() {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(7);
        return findByTimeDateAfter(dateTime);
    }

    // POST new sensor recording
	public EnergyUsage addRecording(@Valid @NotNull EnergyUsage sensorModel) {
		RoomEntity room = roomRepository.findById(sensorModel.getRoomId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found"));
//	    RoomEntity room = roomRepository.findById(sensorModel.getRoomId())
//	            .orElseThrow(() -> new EntityNotFoundException("Room not found")); // gets room entity from db based on id
	    sensorModel.setRoom(roomMapper.entityToDto(room)); // converts to room model and adds to sensorModel
	    	
	    EnergyUsageEntity sensorEntity = energyMapper.dtoToEntity(sensorModel); // converts received model -> entity
	    // If time is not provided, default to the current time
	    if (sensorEntity.getTimeDate() == null) {
	        sensorEntity.setTimeDate(LocalDateTime.now());
	    }
		
		energyRepository.save(sensorEntity); // saves to db
		
		return energyMapper.entityToDto(sensorEntity); // returns model back if successful
	}	
}

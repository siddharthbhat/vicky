package com.ee417.website.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ee417.website.group.entity.RoomEntity;
import com.ee417.website.group.mapper.RoomMapper;
import com.ee417.website.group.models.Room;
import com.ee417.website.group.repository.RoomEntityRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class RoomService {
	@Autowired
	private final RoomEntityRepository repository;
	@Autowired
	private final RoomMapper mapper;
	
	public RoomService(RoomEntityRepository repository, RoomMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	// POST new room
	public Room addRoom(@Valid @NotNull Room room) {
		// Checks for room being present already
		if(roomExists(room.getName())) {
			throw new DataIntegrityViolationException("Room name already exists");
		}
		
		RoomEntity roomEntity = mapper.dtoToEntity(room); // converts to entity for db
		repository.save(roomEntity); // saves to db
		
		return mapper.entityToDto(roomEntity); // converts back and returns to controller		
	}
	
	// Searches db for room name
	private boolean roomExists(String name) {
		return repository.findRoomByName(name).isPresent();
	}
	
	// GET list of rooms
	public List<Room> listRooms() {
		List<RoomEntity> all = repository.findAll(); // gets a list of room entities from db
		return mapper.mapList(all); // converts to room model
	}
}

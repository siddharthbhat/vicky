package com.ee417.website.group.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.ee417.website.group.entity.RoomEntity;
import com.ee417.website.group.models.Room;

/**
 * @author Peter Staunton
 * @date 08/04/24
 * @category mapper
 * Provides MapStruct mapping between entity and model classes
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoomMapper {
	RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class); // allows accessing an instance of mapper class

	List<Room> mapList(List<RoomEntity> entities);
	
	Room entityToDto(RoomEntity entity); // entity -> model
	RoomEntity dtoToEntity(Room model); // model -> entity
}

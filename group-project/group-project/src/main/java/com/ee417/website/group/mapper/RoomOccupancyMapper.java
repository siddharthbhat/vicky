package com.ee417.website.group.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.ee417.website.group.entity.RoomOccupancyEntity;
import com.ee417.website.group.models.RoomOccupancy;

/**
 * @author Peter Staunton
 * @date 08/04/24
 * @category mapper
 * Provides MapStruct mapping between entity and model classes
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoomOccupancyMapper {
	HumidityMapper INSTANCE = Mappers.getMapper(HumidityMapper.class); // allows accessing an instance of mapper class
	
	List<RoomOccupancy> mapList(List<RoomOccupancyEntity> entities);


    RoomOccupancy entityToDto(RoomOccupancyEntity entity); // entity -> model
    RoomOccupancyEntity dtoToEntity(RoomOccupancy model); // model -> entity
}

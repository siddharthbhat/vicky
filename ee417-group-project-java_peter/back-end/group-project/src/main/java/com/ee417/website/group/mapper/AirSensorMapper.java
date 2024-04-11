package com.ee417.website.group.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.ee417.website.group.entity.AirSensorEntity;
import com.ee417.website.group.models.AirSensor;

/**
 * @author Peter Staunton
 * @date 08/04/24
 * @category mapper
 * Provides MapStruct mapping between entity and model classes
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AirSensorMapper {
	AirSensorMapper INSTANCE = Mappers.getMapper(AirSensorMapper.class); // allows accessing an instance of mapper class
	
	List<AirSensor> mapList(List<AirSensorEntity> entities);
	
//	@Mapping(source = "air_quality", target = "air_quality")
    AirSensor entityToDto(AirSensorEntity entity); // entity -> model
//	@Mapping(source = "air_quality", target = "air_quality")
    AirSensorEntity dtoToEntity(AirSensor model); // model -> entity
}

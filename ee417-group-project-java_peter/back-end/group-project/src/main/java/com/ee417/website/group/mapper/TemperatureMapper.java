package com.ee417.website.group.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.ee417.website.group.entity.TemperatureSensorEntity;
import com.ee417.website.group.models.TemperatureSensor;


/**
 * @author Peter Staunton
 * @date 08/04/24
 * @category mapper
 * Provides MapStruct mapping between entity and model classes
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TemperatureMapper {
	TemperatureMapper INSTANCE = Mappers.getMapper(TemperatureMapper.class); // allows accessing an instance of mapper class
	
	List<TemperatureSensor> mapList(List<TemperatureSensorEntity> entities);

    TemperatureSensor entityToDto(TemperatureSensorEntity entity); // entity -> model
    TemperatureSensorEntity dtoToEntity(TemperatureSensor model); // model -> entity
}

package com.ee417.website.group.mapper;

import com.ee417.website.group.entity.NoiseSensorEntity;
import com.ee417.website.group.models.NoiseSensor;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

/**
 * @author Peter Staunton
 * @date 08/04/24
 * @category mapper
 * Provides MapStruct mapping between entity and model classes
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NoiseSensorMapper {
    NoiseSensorMapper INSTANCE = Mappers.getMapper(NoiseSensorMapper.class); // allows accessing an instance of mapper class

    List<NoiseSensor> mapList(List<NoiseSensorEntity> entities);
    
    NoiseSensor entityToDto(NoiseSensorEntity entity); // entity -> model
    NoiseSensorEntity dtoToEntity(NoiseSensor model); // model -> entity
}

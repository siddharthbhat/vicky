package com.ee417.website.group.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.ee417.website.group.entity.HumiditySensorEntity;
import com.ee417.website.group.models.HumiditySensor;


/**
 * @author Peter Staunton
 * @date 08/04/24
 * @category mapper
 * Provides MapStruct mapping between entity and model classes
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HumidityMapper {
	HumidityMapper INSTANCE = Mappers.getMapper(HumidityMapper.class); // allows accessing an instance of mapper class

	List<HumiditySensor> mapList(List<HumiditySensorEntity> entities);
	
    HumiditySensor entityToDto(HumiditySensorEntity entity); // entity -> model
    HumiditySensorEntity dtoToEntity(HumiditySensor model); // model -> entity
}

package com.ee417.website.group.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.ee417.website.group.entity.EnergyUsageEntity;
import com.ee417.website.group.models.EnergyUsage;


/**
 * @author Peter Staunton
 * @date 08/04/24
 * @category mapper
 * Provides MapStruct mapping between entity and model classes
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EnergyUsageMapper {
    EnergyUsageMapper INSTANCE = Mappers.getMapper(EnergyUsageMapper.class); // allows accessing an instance of mapper class

    List<EnergyUsage> mapList(List<EnergyUsageEntity> entities);
    
    EnergyUsage entityToDto(EnergyUsageEntity entity); // entity -> model
    EnergyUsageEntity dtoToEntity(EnergyUsage model); // model -> entity
}

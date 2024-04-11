package com.ee417.website.group.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.ee417.website.group.entity.RoleEntity;
import com.ee417.website.group.models.Role;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
    List<Role>mapList(List<RoleEntity> entities);
    Role entityToDto(RoleEntity entity);
    RoleEntity toEntity(Role user);
}

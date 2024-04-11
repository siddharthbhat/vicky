package com.ee417.website.group.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.ee417.website.group.entity.UserEntity;
import com.ee417.website.group.models.User;

/*
 * Example from class to User objects to UserEntity objects for the db
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {RoleMapper.class})
public interface UserMapper {
	List<User> mapList(List<UserEntity> entities);
    User entityToDto(UserEntity entity);

    UserEntity toEntity(User user);
}

package com.ee417.website.group.mapper;

import com.ee417.website.group.entity.UserEntity;
import com.ee417.website.group.models.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T17:29:22+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<User> mapList(List<UserEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( entities.size() );
        for ( UserEntity userEntity : entities ) {
            list.add( entityToDto( userEntity ) );
        }

        return list;
    }

    @Override
    public User entityToDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( entity.getId() );
        user.username( entity.getUsername() );
        user.firstName( entity.getFirstName() );
        user.lastName( entity.getLastName() );
        user.email( entity.getEmail() );
        user.address( entity.getAddress() );
        user.password( entity.getPassword() );
        user.role( roleMapper.entityToDto( entity.getRole() ) );

        return user.build();
    }

    @Override
    public UserEntity toEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( user.getId() );
        userEntity.setEmail( user.getEmail() );
        userEntity.setUsername( user.getUsername() );
        userEntity.setPassword( user.getPassword() );
        userEntity.setFirstName( user.getFirstName() );
        userEntity.setLastName( user.getLastName() );
        userEntity.setAddress( user.getAddress() );
        userEntity.setRole( roleMapper.toEntity( user.getRole() ) );

        return userEntity;
    }
}

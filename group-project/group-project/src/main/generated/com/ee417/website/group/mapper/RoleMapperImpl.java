package com.ee417.website.group.mapper;

import com.ee417.website.group.entity.RoleEntity;
import com.ee417.website.group.models.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T17:29:22+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public List<Role> mapList(List<RoleEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( entities.size() );
        for ( RoleEntity roleEntity : entities ) {
            list.add( entityToDto( roleEntity ) );
        }

        return list;
    }

    @Override
    public Role entityToDto(RoleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Role role = new Role();

        role.setName( entity.getName() );

        return role;
    }

    @Override
    public RoleEntity toEntity(Role user) {
        if ( user == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setName( user.getName() );

        return roleEntity;
    }
}

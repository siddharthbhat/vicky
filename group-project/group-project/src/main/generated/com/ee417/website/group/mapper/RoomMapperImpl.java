package com.ee417.website.group.mapper;

import com.ee417.website.group.entity.RoomEntity;
import com.ee417.website.group.models.Room;
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
public class RoomMapperImpl implements RoomMapper {

    @Override
    public List<Room> mapList(List<RoomEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Room> list = new ArrayList<Room>( entities.size() );
        for ( RoomEntity roomEntity : entities ) {
            list.add( entityToDto( roomEntity ) );
        }

        return list;
    }

    @Override
    public Room entityToDto(RoomEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Room room = new Room();

        if ( entity.getId() != null ) {
            room.setId( entity.getId() );
        }
        room.setName( entity.getName() );
        room.setCapacity( entity.getCapacity() );
        room.setBuilding( entity.getBuilding() );

        return room;
    }

    @Override
    public RoomEntity dtoToEntity(Room model) {
        if ( model == null ) {
            return null;
        }

        RoomEntity roomEntity = new RoomEntity();

        roomEntity.setId( model.getId() );
        roomEntity.setName( model.getName() );
        roomEntity.setCapacity( model.getCapacity() );
        roomEntity.setBuilding( model.getBuilding() );

        return roomEntity;
    }
}

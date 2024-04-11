package com.ee417.website.group.mapper;

import com.ee417.website.group.entity.RoomEntity;
import com.ee417.website.group.entity.RoomOccupancyEntity;
import com.ee417.website.group.models.Room;
import com.ee417.website.group.models.RoomOccupancy;
import java.time.LocalDateTime;
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
public class RoomOccupancyMapperImpl implements RoomOccupancyMapper {

    @Override
    public List<RoomOccupancy> mapList(List<RoomOccupancyEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RoomOccupancy> list = new ArrayList<RoomOccupancy>( entities.size() );
        for ( RoomOccupancyEntity roomOccupancyEntity : entities ) {
            list.add( entityToDto( roomOccupancyEntity ) );
        }

        return list;
    }

    @Override
    public RoomOccupancy entityToDto(RoomOccupancyEntity entity) {
        if ( entity == null ) {
            return null;
        }

        long id = 0L;
        LocalDateTime timeDate = null;
        int currentOccupancy = 0;

        id = entity.getId();
        timeDate = entity.getTimeDate();
        currentOccupancy = entity.getCurrentOccupancy();

        Long roomId = null;

        RoomOccupancy roomOccupancy = new RoomOccupancy( id, timeDate, roomId, currentOccupancy );

        roomOccupancy.setRoom( roomEntityToRoom( entity.getRoom() ) );

        return roomOccupancy;
    }

    @Override
    public RoomOccupancyEntity dtoToEntity(RoomOccupancy model) {
        if ( model == null ) {
            return null;
        }

        RoomOccupancyEntity roomOccupancyEntity = new RoomOccupancyEntity();

        roomOccupancyEntity.setId( model.getId() );
        roomOccupancyEntity.setTimeDate( model.getTimeDate() );
        roomOccupancyEntity.setRoom( roomToRoomEntity( model.getRoom() ) );
        roomOccupancyEntity.setCurrentOccupancy( model.getCurrentOccupancy() );

        return roomOccupancyEntity;
    }

    protected Room roomEntityToRoom(RoomEntity roomEntity) {
        if ( roomEntity == null ) {
            return null;
        }

        Room room = new Room();

        if ( roomEntity.getId() != null ) {
            room.setId( roomEntity.getId() );
        }
        room.setName( roomEntity.getName() );
        room.setCapacity( roomEntity.getCapacity() );
        room.setBuilding( roomEntity.getBuilding() );

        return room;
    }

    protected RoomEntity roomToRoomEntity(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomEntity roomEntity = new RoomEntity();

        roomEntity.setId( room.getId() );
        roomEntity.setName( room.getName() );
        roomEntity.setCapacity( room.getCapacity() );
        roomEntity.setBuilding( room.getBuilding() );

        return roomEntity;
    }
}

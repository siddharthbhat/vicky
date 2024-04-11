package com.ee417.website.group.mapper;

import com.ee417.website.group.entity.NoiseSensorEntity;
import com.ee417.website.group.entity.RoomEntity;
import com.ee417.website.group.models.NoiseSensor;
import com.ee417.website.group.models.Room;
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
public class NoiseSensorMapperImpl implements NoiseSensorMapper {

    @Override
    public List<NoiseSensor> mapList(List<NoiseSensorEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<NoiseSensor> list = new ArrayList<NoiseSensor>( entities.size() );
        for ( NoiseSensorEntity noiseSensorEntity : entities ) {
            list.add( entityToDto( noiseSensorEntity ) );
        }

        return list;
    }

    @Override
    public NoiseSensor entityToDto(NoiseSensorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        long id = 0L;
        LocalDateTime timeDate = null;
        double noiseLevelDB = 0.0d;

        id = entity.getId();
        timeDate = entity.getTimeDate();
        noiseLevelDB = entity.getNoiseLevelDB();

        Long roomId = null;

        NoiseSensor noiseSensor = new NoiseSensor( id, timeDate, roomId, noiseLevelDB );

        noiseSensor.setRoom( roomEntityToRoom( entity.getRoom() ) );

        return noiseSensor;
    }

    @Override
    public NoiseSensorEntity dtoToEntity(NoiseSensor model) {
        if ( model == null ) {
            return null;
        }

        NoiseSensorEntity noiseSensorEntity = new NoiseSensorEntity();

        noiseSensorEntity.setId( model.getId() );
        noiseSensorEntity.setTimeDate( model.getTimeDate() );
        noiseSensorEntity.setRoom( roomToRoomEntity( model.getRoom() ) );
        noiseSensorEntity.setNoiseLevelDB( model.getNoiseLevelDB() );

        return noiseSensorEntity;
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

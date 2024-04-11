package com.ee417.website.group.mapper;

import com.ee417.website.group.entity.HumiditySensorEntity;
import com.ee417.website.group.entity.RoomEntity;
import com.ee417.website.group.models.HumiditySensor;
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
public class HumidityMapperImpl implements HumidityMapper {

    @Override
    public List<HumiditySensor> mapList(List<HumiditySensorEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<HumiditySensor> list = new ArrayList<HumiditySensor>( entities.size() );
        for ( HumiditySensorEntity humiditySensorEntity : entities ) {
            list.add( entityToDto( humiditySensorEntity ) );
        }

        return list;
    }

    @Override
    public HumiditySensor entityToDto(HumiditySensorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        LocalDateTime timeDate = null;
        double humidity = 0.0d;

        id = entity.getId();
        timeDate = entity.getTimeDate();
        humidity = entity.getHumidity();

        long roomId = 0L;

        HumiditySensor humiditySensor = new HumiditySensor( id, timeDate, roomId, humidity );

        humiditySensor.setRoom( roomEntityToRoom( entity.getRoom() ) );

        return humiditySensor;
    }

    @Override
    public HumiditySensorEntity dtoToEntity(HumiditySensor model) {
        if ( model == null ) {
            return null;
        }

        HumiditySensorEntity humiditySensorEntity = new HumiditySensorEntity();

        if ( model.getId() != null ) {
            humiditySensorEntity.setId( model.getId() );
        }
        humiditySensorEntity.setTimeDate( model.getTimeDate() );
        humiditySensorEntity.setRoom( roomToRoomEntity( model.getRoom() ) );
        humiditySensorEntity.setHumidity( model.getHumidity() );

        return humiditySensorEntity;
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

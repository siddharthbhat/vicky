package com.ee417.website.group.mapper;

import com.ee417.website.group.entity.RoomEntity;
import com.ee417.website.group.entity.TemperatureSensorEntity;
import com.ee417.website.group.models.Room;
import com.ee417.website.group.models.TemperatureSensor;
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
public class TemperatureMapperImpl implements TemperatureMapper {

    @Override
    public List<TemperatureSensor> mapList(List<TemperatureSensorEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<TemperatureSensor> list = new ArrayList<TemperatureSensor>( entities.size() );
        for ( TemperatureSensorEntity temperatureSensorEntity : entities ) {
            list.add( entityToDto( temperatureSensorEntity ) );
        }

        return list;
    }

    @Override
    public TemperatureSensor entityToDto(TemperatureSensorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TemperatureSensor temperatureSensor = new TemperatureSensor();

        temperatureSensor.setId( entity.getId() );
        temperatureSensor.setTimeDate( entity.getTimeDate() );
        temperatureSensor.setRoom( roomEntityToRoom( entity.getRoom() ) );
        temperatureSensor.setTemperature( entity.getTemperature() );

        return temperatureSensor;
    }

    @Override
    public TemperatureSensorEntity dtoToEntity(TemperatureSensor model) {
        if ( model == null ) {
            return null;
        }

        TemperatureSensorEntity temperatureSensorEntity = new TemperatureSensorEntity();

        if ( model.getId() != null ) {
            temperatureSensorEntity.setId( model.getId() );
        }
        temperatureSensorEntity.setTimeDate( model.getTimeDate() );
        temperatureSensorEntity.setRoom( roomToRoomEntity( model.getRoom() ) );
        temperatureSensorEntity.setTemperature( model.getTemperature() );

        return temperatureSensorEntity;
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

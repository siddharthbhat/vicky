package com.ee417.website.group.mapper;

import com.ee417.website.group.entity.EnergyUsageEntity;
import com.ee417.website.group.entity.RoomEntity;
import com.ee417.website.group.models.EnergyUsage;
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
public class EnergyUsageMapperImpl implements EnergyUsageMapper {

    @Override
    public List<EnergyUsage> mapList(List<EnergyUsageEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<EnergyUsage> list = new ArrayList<EnergyUsage>( entities.size() );
        for ( EnergyUsageEntity energyUsageEntity : entities ) {
            list.add( entityToDto( energyUsageEntity ) );
        }

        return list;
    }

    @Override
    public EnergyUsage entityToDto(EnergyUsageEntity entity) {
        if ( entity == null ) {
            return null;
        }

        long id = 0L;
        LocalDateTime timeDate = null;
        int energyUsage = 0;

        id = entity.getId();
        timeDate = entity.getTimeDate();
        energyUsage = entity.getEnergyUsage();

        Long roomId = null;

        EnergyUsage energyUsage1 = new EnergyUsage( id, timeDate, roomId, energyUsage );

        energyUsage1.setRoom( roomEntityToRoom( entity.getRoom() ) );

        return energyUsage1;
    }

    @Override
    public EnergyUsageEntity dtoToEntity(EnergyUsage model) {
        if ( model == null ) {
            return null;
        }

        EnergyUsageEntity energyUsageEntity = new EnergyUsageEntity();

        energyUsageEntity.setId( model.getId() );
        energyUsageEntity.setTimeDate( model.getTimeDate() );
        energyUsageEntity.setRoom( roomToRoomEntity( model.getRoom() ) );
        energyUsageEntity.setEnergyUsage( model.getEnergyUsage() );

        return energyUsageEntity;
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

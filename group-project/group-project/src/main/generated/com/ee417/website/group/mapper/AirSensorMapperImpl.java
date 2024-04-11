package com.ee417.website.group.mapper;

import com.ee417.website.group.entity.AirSensorEntity;
import com.ee417.website.group.entity.RoomEntity;
import com.ee417.website.group.models.AirSensor;
import com.ee417.website.group.models.Room;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T17:29:22+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class AirSensorMapperImpl implements AirSensorMapper {

    private final DatatypeFactory datatypeFactory;

    public AirSensorMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public List<AirSensor> mapList(List<AirSensorEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AirSensor> list = new ArrayList<AirSensor>( entities.size() );
        for ( AirSensorEntity airSensorEntity : entities ) {
            list.add( entityToDto( airSensorEntity ) );
        }

        return list;
    }

    @Override
    public AirSensor entityToDto(AirSensorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AirSensor airSensor = new AirSensor();

        airSensor.setId( entity.getId() );
        airSensor.setTimeDate( xmlGregorianCalendarToLocalDate( localDateTimeToXmlGregorianCalendar( entity.getTimeDate() ) ) );
        airSensor.setRoom( roomEntityToRoom( entity.getRoom() ) );
        airSensor.setAir_quality( entity.getAir_quality() );

        return airSensor;
    }

    @Override
    public AirSensorEntity dtoToEntity(AirSensor model) {
        if ( model == null ) {
            return null;
        }

        AirSensorEntity airSensorEntity = new AirSensorEntity();

        airSensorEntity.setId( model.getId() );
        airSensorEntity.settimeDate( xmlGregorianCalendarToLocalDateTime( localDateToXmlGregorianCalendar( model.getTimeDate() ) ) );
        airSensorEntity.setRoom( roomToRoomEntity( model.getRoom() ) );
        airSensorEntity.setAir_quality( model.getAir_quality() );

        return airSensorEntity;
    }

    private XMLGregorianCalendar localDateToXmlGregorianCalendar( LocalDate localDate ) {
        if ( localDate == null ) {
            return null;
        }

        return datatypeFactory.newXMLGregorianCalendarDate(
            localDate.getYear(),
            localDate.getMonthValue(),
            localDate.getDayOfMonth(),
            DatatypeConstants.FIELD_UNDEFINED );
    }

    private XMLGregorianCalendar localDateTimeToXmlGregorianCalendar( LocalDateTime localDateTime ) {
        if ( localDateTime == null ) {
            return null;
        }

        return datatypeFactory.newXMLGregorianCalendar(
            localDateTime.getYear(),
            localDateTime.getMonthValue(),
            localDateTime.getDayOfMonth(),
            localDateTime.getHour(),
            localDateTime.getMinute(),
            localDateTime.getSecond(),
            localDateTime.get( ChronoField.MILLI_OF_SECOND ),
            DatatypeConstants.FIELD_UNDEFINED );
    }

    private static LocalDate xmlGregorianCalendarToLocalDate( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        return LocalDate.of( xcal.getYear(), xcal.getMonth(), xcal.getDay() );
    }

    private static LocalDateTime xmlGregorianCalendarToLocalDateTime( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        if ( xcal.getYear() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMonth() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getDay() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getHour() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMinute() != DatatypeConstants.FIELD_UNDEFINED
        ) {
            if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED
                && xcal.getMillisecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond(),
                    Duration.ofMillis( xcal.getMillisecond() ).getNano()
                );
            }
            else if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond()
                );
            }
            else {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute()
                );
            }
        }
        return null;
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

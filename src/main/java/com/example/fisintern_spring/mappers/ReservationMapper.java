package com.example.fisintern_spring.mappers;

import com.example.fisintern_spring.dtos.ReservationDto;
import com.example.fisintern_spring.entities.Reservation;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {
    Reservation toEntity(ReservationDto reservationDto);

    ReservationDto toDto(Reservation reservation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Reservation partialUpdate(ReservationDto reservationDto, @MappingTarget Reservation reservation);
}
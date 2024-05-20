package com.example.fisintern_spring.mappers;

import com.example.fisintern_spring.dtos.TimekeepingDto;
import com.example.fisintern_spring.entities.Timekeeping;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TimekeepingMapper {
    Timekeeping toEntity(TimekeepingDto timekeepingDto);

    TimekeepingDto toDto(Timekeeping timekeeping);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Timekeeping partialUpdate(TimekeepingDto timekeepingDto, @MappingTarget Timekeeping timekeeping);
}
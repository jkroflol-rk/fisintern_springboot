package com.example.fisintern_spring.mappers;

import com.example.fisintern_spring.dtos.ZoneDto;
import com.example.fisintern_spring.entities.Zone;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ZoneMapper {
    Zone toEntity(ZoneDto zoneDto);

    ZoneDto toDto(Zone zone);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Zone partialUpdate(ZoneDto zoneDto, @MappingTarget Zone zone);
}
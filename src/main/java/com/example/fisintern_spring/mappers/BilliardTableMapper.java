package com.example.fisintern_spring.mappers;

import com.example.fisintern_spring.dtos.BilliardTableDto;
import com.example.fisintern_spring.entities.BilliardTable;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BilliardTableMapper {
    BilliardTable toEntity(BilliardTableDto billiardTableDto);

    BilliardTableDto toDto(BilliardTable billiardTable);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BilliardTable partialUpdate(BilliardTableDto billiardTableDto, @MappingTarget BilliardTable billiardTable);
}
package com.example.fisintern_spring.mappers;

import com.example.fisintern_spring.dtos.BillDto;
import com.example.fisintern_spring.entities.Bill;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BillMapper {
    Bill toEntity(BillDto billDto);

    BillDto toDto(Bill bill);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Bill partialUpdate(BillDto billDto, @MappingTarget Bill bill);
}
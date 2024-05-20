package com.example.fisintern_spring.mappers;

import com.example.fisintern_spring.dtos.DetailBillDto;
import com.example.fisintern_spring.entities.DetailBill;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DetailBillMapper {
    DetailBill toEntity(DetailBillDto detailBillDto);

    DetailBillDto toDto(DetailBill detailBill);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DetailBill partialUpdate(DetailBillDto detailBillDto, @MappingTarget DetailBill detailBill);
}
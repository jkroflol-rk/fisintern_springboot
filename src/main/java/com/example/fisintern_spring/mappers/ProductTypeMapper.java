package com.example.fisintern_spring.mappers;

import com.example.fisintern_spring.dtos.ProductTypeDto;
import com.example.fisintern_spring.entities.ProductType;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductTypeMapper {
    ProductType toEntity(ProductTypeDto productTypeDto);

    ProductTypeDto toDto(ProductType productType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProductType partialUpdate(ProductTypeDto productTypeDto, @MappingTarget ProductType productType);
}
package com.example.fisintern_spring.mappers;

import com.example.fisintern_spring.dtos.ImportInvoiceDto;
import com.example.fisintern_spring.entities.ImportInvoice;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ImportInvoiceMapper {
    ImportInvoice toEntity(ImportInvoiceDto importInvoiceDto);

    ImportInvoiceDto toDto(ImportInvoice importInvoice);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ImportInvoice partialUpdate(ImportInvoiceDto importInvoiceDto, @MappingTarget ImportInvoice importInvoice);
}
package com.example.fisintern_spring.mappers;

import com.example.fisintern_spring.dtos.PayrollDto;
import com.example.fisintern_spring.entities.Payroll;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PayrollMapper {
    Payroll toEntity(PayrollDto payrollDto);

    PayrollDto toDto(Payroll payroll);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payroll partialUpdate(PayrollDto payrollDto, @MappingTarget Payroll payroll);
}
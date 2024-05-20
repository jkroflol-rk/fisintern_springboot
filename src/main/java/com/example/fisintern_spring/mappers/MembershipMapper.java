package com.example.fisintern_spring.mappers;

import com.example.fisintern_spring.dtos.MembershipDto;
import com.example.fisintern_spring.entities.Membership;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MembershipMapper {
    Membership toEntity(MembershipDto membershipDto);

    @AfterMapping
    default void linkCustomers(@MappingTarget Membership membership) {
        membership.getCustomers().forEach(customer -> customer.setMembership(membership));
    }

    MembershipDto toDto(Membership membership);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Membership partialUpdate(MembershipDto membershipDto, @MappingTarget Membership membership);
}
package com.foreheed.ozedemo.rest.mappers;

import org.mapstruct.Mapper;

import com.foreheed.ozedemo.persistence.entities.StaffMember;
import com.foreheed.ozedemo.rest.domain.CreateStaffMemberRequest;
import com.foreheed.ozedemo.rest.domain.CreateStaffMemberResponse;
import com.foreheed.ozedemo.rest.domain.UpdateStaffMemberRequest;
import com.foreheed.ozedemo.rest.domain.UpdateStaffMemberResponse;

@Mapper(componentModel = "spring")
public interface StaffMemberMapper {

	StaffMember toStaffMemberFromCreateRequest(CreateStaffMemberRequest request);
	
	CreateStaffMemberResponse toCreateResponseFromStaffMember(StaffMember staffMember);
	
	StaffMember toStaffMemberFromUpdateRequest(UpdateStaffMemberRequest request);
	
	UpdateStaffMemberResponse toUpdateResponseFromStaffMember(StaffMember staffMember);
	
}

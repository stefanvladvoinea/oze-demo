package com.foreheed.ozedemo.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foreheed.ozedemo.rest.domain.CreateStaffMemberRequest;
import com.foreheed.ozedemo.rest.domain.CreateStaffMemberResponse;
import com.foreheed.ozedemo.rest.domain.UpdateStaffMemberRequest;
import com.foreheed.ozedemo.rest.domain.UpdateStaffMemberResponse;
import com.foreheed.ozedemo.rest.mappers.StaffMemberMapper;
import com.foreheed.ozedemo.service.StaffMembersService;

@RestController
@RequestMapping(path = "/staff-members")
public class StaffMembersController {
	
	@Autowired
	private StaffMembersService staffMembersService;
	
	@Autowired
	private StaffMemberMapper staffMemberMapper;
	
	@PostMapping
	public CreateStaffMemberResponse create(@RequestBody CreateStaffMemberRequest request) {
		return staffMemberMapper.toCreateResponseFromStaffMember(
				staffMembersService.create(staffMemberMapper.toStaffMemberFromCreateRequest(request)));
	}

	@PutMapping("/{id}")
	public UpdateStaffMemberResponse updateStaffMember(@RequestBody UpdateStaffMemberRequest request, @PathVariable Integer id) {
		return staffMemberMapper.toUpdateResponseFromStaffMember(
				staffMembersService.update(id, staffMemberMapper.toStaffMemberFromUpdateRequest(request)));
	}
}

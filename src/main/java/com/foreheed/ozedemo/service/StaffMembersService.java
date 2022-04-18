package com.foreheed.ozedemo.service;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.foreheed.ozedemo.persistence.entities.StaffMember;
import com.foreheed.ozedemo.persistence.repositories.StaffMembersRepository;
import com.foreheed.ozedemo.service.exception.NotFoundBusinessException;

public class StaffMembersService {

	private final StaffMembersRepository staffMembersRepository;
	
	public StaffMembersService(StaffMembersRepository staffMembersRepository) {
		this.staffMembersRepository = staffMembersRepository;
	}
	
	public boolean isStaffMemberUuidValid(String uuid) {
		return staffMembersRepository.countByUuid(UUID.fromString(uuid)) == 1;
	}
	
	public StaffMember create(StaffMember staffMember) {
		staffMember.setUuid(UUID.randomUUID());
		staffMember.setRegistrationDate(ZonedDateTime.now());
		return staffMembersRepository.save(staffMember);
	}
	
	public StaffMember update(Integer id, StaffMember newStaffMember) {
		return staffMembersRepository.findById(id)
				.map(oldStaffMember -> {
					oldStaffMember.setName(newStaffMember.getName());
					return staffMembersRepository.save(oldStaffMember);
				})
				.orElseThrow(() -> new NotFoundBusinessException("staff member not found"));
		
	}
}

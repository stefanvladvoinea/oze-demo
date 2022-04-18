package com.foreheed.ozedemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.foreheed.ozedemo.persistence.entities.StaffMember;
import com.foreheed.ozedemo.service.StaffMembersService;
import com.foreheed.ozedemo.service.exception.NotFoundBusinessException;

@SpringBootTest
class OzeDemoApplicationTests {
	
	@Autowired
	private StaffMembersService staffMembersService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void staffMemberCreation() {
		StaffMember staffMember = createStaffMember("Test Staff Member Creation");
		assertNotNull(staffMember.getId());
		assertNotNull(staffMember.getUuid());
		assertNotNull(staffMember.getRegistrationDate());
		assertTrue(staffMembersService.isStaffMemberUuidValid(staffMember.getUuid().toString()));
	}
	
	private StaffMember createStaffMember(String name) {
		StaffMember newStaffMember = new StaffMember();
		newStaffMember.setName(name);
		return staffMembersService.create(newStaffMember);
	}
	
	@Test
	void staffMemberUpdate() {
		String newName = "Updated Test Staff Member Name";
		StaffMember newStaffMember = new StaffMember();
		newStaffMember.setName(newName);
		StaffMember staffMember = createStaffMember("Test Staff Member Update");
		StaffMember updatedStaffMember = staffMembersService.update(staffMember.getId(), newStaffMember);
		assertEquals(newName, updatedStaffMember.getName());
	}
	
	@Test
	void staffMemberUpdateIdNotFound() {
		String newName = "Updated Test Staff Member Name";
		StaffMember newStaffMember = new StaffMember();
		newStaffMember.setName(newName);
		assertThrows(NotFoundBusinessException.class, () -> staffMembersService.update(1001, newStaffMember));
	}

}

package com.foreheed.ozedemo.rest.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.foreheed.ozedemo.service.StaffMembersService;
import com.foreheed.ozedemo.service.exception.AuthenticationBusinessException;

@Component
public class StaffMemberUuidInterceptor implements HandlerInterceptor {
	
	@Autowired
	private StaffMembersService staffMembersService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(!staffMembersService.isStaffMemberUuidValid(request.getHeader("X-StaffMember-Uuid"))) {
			throw new AuthenticationBusinessException("no staff member header or invalid uuid");
		}
		return true;
	}
}

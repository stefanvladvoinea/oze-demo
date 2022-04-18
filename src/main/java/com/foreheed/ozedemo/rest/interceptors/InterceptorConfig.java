package com.foreheed.ozedemo.rest.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private StaffMemberUuidInterceptor staffMemberUuidInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(staffMemberUuidInterceptor).excludePathPatterns("/staff-members");
	}
}

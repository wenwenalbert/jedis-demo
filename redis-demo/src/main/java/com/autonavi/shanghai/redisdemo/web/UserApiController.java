package com.autonavi.shanghai.redisdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autonavi.shanghai.redisdemo.persist.mapper.UserMapper;

@RestController
public class UserApiController {
	
	@Autowired
	private UserMapper mapper;
	
	@RequestMapping("/user/get")
	public String getUser() {
		return mapper.get("name");
	}
}

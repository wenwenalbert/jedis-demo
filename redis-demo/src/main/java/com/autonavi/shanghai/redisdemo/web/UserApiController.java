package com.autonavi.shanghai.redisdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.autonavi.shanghai.redisdemo.persist.mapper.UserMapper;

@RestController
public class UserApiController {
	
	private static final String DEFAULT_CONTENT_TYPE = "application/json;charset=UTF-8";

	@Autowired
	private UserMapper mapper;
	
	@RequestMapping("/user/get")
	public void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType(DEFAULT_CONTENT_TYPE);
		PrintWriter pw = response.getWriter();
		pw.write(JSON.toJSONString(mapper.getUserAll()));
		pw.close();
	}
}

package com.autonavi.shanghai.redisdemo.web.gui;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.autonavi.shanghai.redisdemo.util.ResponseInfo;

@Controller
public class SigninController {
	
	private static final Logger logger = LoggerFactory.getLogger(SigninController.class);

	@RequestMapping(value = "/signin")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		return "signin";
	}
	
	@RequestMapping(value = "/signin/verify")
	public void loginVerify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String captchaInput = request.getParameter("captcha");
		
		String captchaSrc = (String) request.getSession().getAttribute("rand");
		request.getSession().removeAttribute("rand");

		ResponseInfo responseInfo = new ResponseInfo();
		
		if (captchaSrc != null) {
			if (captchaInput.equalsIgnoreCase(captchaSrc)) {
				if (username.equals("admin") && password.equals("autonavi&2015")) {
					responseInfo.setStatus(true);
					responseInfo.setMessage("验证成功");
					logger.debug("User " + username + " signined.");
					request.getSession().setAttribute("user", username);
				} else {
					responseInfo.setStatus(false);
					responseInfo.setMessage("密码或用户名有误");
				}
			} else {
				responseInfo.setStatus(false);
				responseInfo.setMessage("验证码错误");
			}
		} else {
			responseInfo.setStatus(false);
			responseInfo.setMessage("登录失败,请重新登录");
		}
		
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().write(JSON.toJSONString(responseInfo));
	}
	
}

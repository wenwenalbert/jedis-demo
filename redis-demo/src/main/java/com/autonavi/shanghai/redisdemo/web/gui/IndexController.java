/**
 * 
 */
package com.autonavi.shanghai.redisdemo.web.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.autonavi.shanghai.redisdemo.persist.mapper.UserMapper;

/**
 * @author albert
 *
 */

@Controller
public class IndexController {

	@Autowired
	private UserMapper mapper;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("users", mapper.getUserAll());
		return mav;
	}
}

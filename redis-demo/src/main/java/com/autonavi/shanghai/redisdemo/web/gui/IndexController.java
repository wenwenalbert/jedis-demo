/**
 * 
 */
package com.autonavi.shanghai.redisdemo.web.gui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author albert
 *
 */

@Controller
public class IndexController {

	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		//mav.addObject("students", service.selectStudentInfo());
		return mav;
	}
}

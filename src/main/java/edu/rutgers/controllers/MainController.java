package edu.rutgers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.rutgers.util.enums.PAGES;

/**
 * Applications main controller. Its main function is to redirect traffic of requests to proper handlers and manage model for setting up views.
 *
 */
@Controller
public class MainController {
	
	/**
	 * Temporary test method for application mapped to the root of the app.
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/")
	public ModelAndView helloWorld() {
		return new ModelAndView(PAGES.PORTAL.toString());
	}
}

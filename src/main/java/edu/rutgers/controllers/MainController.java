package edu.rutgers.controllers;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@PostConstruct
	public void initAppState() {
		System.out.println(" STARTING APPLICATION !!!! - MAIN CONTROLLER INITIALIZED");
		/*
		ConfigReader.getInstance();
		LoggerFactory.getLogger(LOGGER_TYPE.CONSOLE);
		*/
	}
	
	@ResponseBody
	@RequestMapping(value = "/")
	public String helloWorld() {
		return "Hello, world!";
	}
}

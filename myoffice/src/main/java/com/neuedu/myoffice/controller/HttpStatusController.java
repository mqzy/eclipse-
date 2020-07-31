package com.neuedu.myoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HttpStatusController {
	
	@RequestMapping(value = "/error/404",method = RequestMethod.GET)
	public String handler404() {
		return "error/404";
	}
	
	@RequestMapping(value = "/error/500",method = RequestMethod.GET)
	public String handler500() {
		return "error/500";
	}
	
}

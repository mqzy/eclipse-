package com.neuedu.myoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	@RequestMapping(value = {"","/","index"},method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "left",method = RequestMethod.GET)
	public String left() {
		return "left";
	}
	
	@RequestMapping(value = "content",method = RequestMethod.GET)
	public String content() {
		return "content";
	}
}

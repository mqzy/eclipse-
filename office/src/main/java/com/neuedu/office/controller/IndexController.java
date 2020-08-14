package com.neuedu.office.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class IndexController {

	@GetMapping(value = {"","index"})
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "content")
	public String content() {
		return "content";
	}
}

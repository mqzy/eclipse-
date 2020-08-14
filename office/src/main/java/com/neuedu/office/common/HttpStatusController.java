package com.neuedu.office.common;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HttpStatusController implements ErrorController{
	private static final String ERROR_PATH = "/error";
	
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	@GetMapping(value = ERROR_PATH)
	public String httpStatusHandler(HttpServletResponse response) {
		int code = response.getStatus();
		return ERROR_PATH+"/"+code;
	}
}

package com.neuedu.office.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.office.bean.ResultBean;

@ControllerAdvice(basePackages = {"com.neuedu.office","com.neuedu.office.controller","com.neuedu.office.service.impl","com.neuedu.office.dao"})
public class GlobalExcrpyionController {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public ResultBean n(RuntimeException ex) {
		return new ResultBean(5005,false,ex.getMessage(),ex);
	}
//	@ExceptionHandler(RuntimeException.class)
//	public String exceptionHandler(RuntimeException ex,Model model) {
//		model.addAttribute("error",ResultBean.builder().code(500).successed(false).message(ex.getMessage()).data(ex).build());
//		return "/error/exception";
//	}
}

package com.neuedu.myoffice.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice(basePackages = {"com.neuedu.myoffice","com.neuedu.myoffice.controller","com.neuedu.myoffice.service","com.neuedu.myoffice.dao"})
public class GlobalExceptionController {
	
	@ExceptionHandler(RuntimeException.class)
	public String errorHandler(Exception ex,Model model) {
		model.addAttribute("error",ex);
		return "error/error";
	}
	
    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes)
    {
        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        return "redirect:/uploadResult";
    }
	
//	@ExceptionHandler(RuntimeException.class)
//	@ResponseBody
//	public ResultBean<RuntimeException> handler(RuntimeException ex) {
//		return new ResultBean<RuntimeException>(5000,false,ex.getMessage(),ex);
//	}
}

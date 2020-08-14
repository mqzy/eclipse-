package com.neuedu.office.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.office.bean.ResultBean;
import com.neuedu.office.entity.Management;
import com.neuedu.office.service.ManagementService;

@Controller
public class ManagementController {
	@Autowired
	private ManagementService managementService;
	
	@GetMapping(value = "login")
	public String login() {
		return "login";
	}
	
	@PostMapping(value = "checklogin")
	@ResponseBody
	public ResultBean checklogin(@Validated Management management,BindingResult bindingResult,HttpSession session) {
		ResultBean r = null;
		if (bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getField()+": "+f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5004,false,msg.toString(),"");
			return r;
		}
		Management targetManagement = managementService.login(management.getName(),management.getPassword());
		if (targetManagement != null) {
			targetManagement.setPassword("******");
			r = new ResultBean(200,true,"登陆成功","");
			session.setAttribute("management", targetManagement);
		}else {
			r = new ResultBean(500,false,"登陆失败","");
		}
		return r;
	}
	
	@GetMapping(value = "exit")
	public String exit(HttpSession session) {
		session.removeAttribute("management");
		return "login";
	}
}

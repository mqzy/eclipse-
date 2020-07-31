package com.neuedu.myoffice.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.myoffice.bean.ResultBean;
import com.neuedu.myoffice.entity.Management;
import com.neuedu.myoffice.service.ManagementService;

@Controller
public class ManagementController {
	@Autowired
	private ManagementService managementService;
	
	@RequestMapping(value = {"","/","login"},method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "checklogin",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> checklogin(String name,String password,HttpSession session) {
		Management management = managementService.login(name, password);
		ResultBean<String> resultBean = new ResultBean<String>(200,true,"登陆成功");
		if (management == null) {
			resultBean = new ResultBean<String>(500,false,"登陆失败");
			session.removeAttribute("management");
		}else {
			System.out.println(management);
			management.setPassword("******");
			session.setAttribute("management", management);
		}
		return resultBean;
	}
	
	@RequestMapping(value = "exit",method = RequestMethod.GET)
	public String exit(HttpSession session) {
		session.removeAttribute("management");
		return "login";
	}
}

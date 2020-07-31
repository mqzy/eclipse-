package com.neuedu.carboom.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.carboom.bean.ResultBean;
import com.neuedu.carboom.entity.User;
import com.neuedu.carboom.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "checklogin",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> checklogin(String name,String password,HttpSession session) {
		//System.out.println(name+" "+password);
		User user = userService.login(name, password);
		ResultBean<String> resultBean = new ResultBean<String>(200,true,"登陆成功");
		if (user == null) {
			resultBean = new ResultBean<String>(500,false,"登陆失败");
			session.removeAttribute("user");
		}else {
			user.setPassword("******");
			session.setAttribute("user", user);
		}
		return resultBean;
	}
	
	
	@RequestMapping(value = "exit",method = RequestMethod.GET)
	public String exit(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
}

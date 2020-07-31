package com.neuedu.myoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.myoffice.bean.ResultBean;
import com.neuedu.myoffice.entity.Department;
import com.neuedu.myoffice.service.DepartmentService;

@RestController
public class DemoController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "department/managerDepartments/list",method = RequestMethod.GET)
	public ResultBean<List<Department>> managerDepartments(Model model) {
		List<Department> departments = departmentService.selectAll();	
		ResultBean<List<Department>> resultBean = new ResultBean<List<Department>>(200,true,"查询所有部门成功",departments);
		model.addAttribute("myoffice",resultBean);
		return resultBean;
	}
}

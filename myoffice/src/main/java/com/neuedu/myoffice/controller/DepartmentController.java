package com.neuedu.myoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neuedu.myoffice.bean.ResultBean;
import com.neuedu.myoffice.entity.Department;
import com.neuedu.myoffice.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "department/managerDepartments",method = RequestMethod.GET)
	public String managerDepartments(Model model) {
		List<Department> departments = departmentService.selectAll();	
		ResultBean<List<Department>> resultBean = new ResultBean<List<Department>>(200,true,"查询所有部门成功",departments);
		model.addAttribute("myoffice",resultBean);
		return "department/managerDepartments";
	}
	
	@RequestMapping(value = "department/find",method = RequestMethod.GET)
	public String updataDepartment(String id,String name,String type,Model model) {
		List<Department> departments = departmentService.findByCondition(id, name, type);
		ResultBean<List<Department>> resultBean = new ResultBean<List<Department>>(200,true,"查询所有部门成功",departments);
		model.addAttribute("myoffice",resultBean);
		return "department/managerDepartments";
	}
	
}

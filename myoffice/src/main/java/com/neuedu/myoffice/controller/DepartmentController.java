package com.neuedu.myoffice.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "department/createDepartment",method = RequestMethod.GET)
	public String x() {
		return "department/createDepartment";
	}
	
	@RequestMapping(value = "department/insert",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> insert(String id, String name, String type, String telephone, String fax, String description, String predepartment, String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Department department = new Department(id, name, type, telephone, fax, description, predepartment,sdf.parse(date));
		boolean flag = departmentService.insert(department);
		ResultBean<String> resultBean = new ResultBean<String>();
		if (flag) {
			resultBean.setCode(200);
			resultBean.setSuccessed(true);
			resultBean.setMessage("新增部门成功");
		}else {
			resultBean.setCode(500);
			resultBean.setSuccessed(false);
			resultBean.setMessage("新增部门失败");
		}
		return resultBean;
	}
	
	@RequestMapping(value = "department/employeesDepartment",method = RequestMethod.GET)
	public String employeesDepartment() {
		return "department/employeesDepartment";
	}
	
	@RequestMapping(value = "department/updataDepartment",method = RequestMethod.GET)
	public String updataDepartment() {
		return "department/updataDepartment";
	}
}

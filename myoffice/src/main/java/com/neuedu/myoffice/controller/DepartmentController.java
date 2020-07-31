package com.neuedu.myoffice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.myoffice.bean.ResultBean;
import com.neuedu.myoffice.entity.Department;
import com.neuedu.myoffice.service.DepartmentService;



@Controller
public class DepartmentController {
	
//	@InitBinder
//    public void InitBinder(WebDataBinder binder) {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		sdf.setLenient(false);
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true));
//	}
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "department/managerDepartments",method = RequestMethod.GET)
	public String managerDepartments() {
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
	public ResultBean<String> insert(Department department)  {
		boolean flag = departmentService.insert(department);
		ResultBean<String> resultBean = new ResultBean<String>();
		if (flag) {
			resultBean.setCode(200);
			resultBean.setSuccessed(true);
			resultBean.setMessage("新增部门成功,编号为："+department.getId());
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
	
	@RequestMapping(value = "department/updataDepartment/{id}",method = RequestMethod.GET)
	public String updataDepartment(@PathVariable("id")String id,Model model) {
		Department department = departmentService.selectById(id);
		model.addAttribute("myoffice", new ResultBean<Department>(200,true,"查询成功",department));
		return "department/updataDepartment";
	}
	
	@RequestMapping(value = "department/update",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> update(Department department)  {
		boolean flag = departmentService.update(department);
		ResultBean<String> resultBean = new ResultBean<String>();
		if (flag) {
			resultBean.setCode(200);
			resultBean.setSuccessed(true);
			resultBean.setMessage("修改部门成功");
		}else {
			resultBean.setCode(500);
			resultBean.setSuccessed(false);
			resultBean.setMessage("修改部门失败");
		}
		return resultBean;
	}
	
	@RequestMapping(value = "department/delete",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> delete(@RequestParam("ids[]")String[] ids) {
		boolean flag = departmentService.batchDelete(ids);
		ResultBean<String> resultBean = new ResultBean<String>();
		if (flag) 
			resultBean = new ResultBean<String>(200,true,"删除部门成功");
		else
			resultBean = new ResultBean<String>(500,false,"删除部门失败");		
		return resultBean;
	}
}

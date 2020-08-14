package com.neuedu.office.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.office.bean.ResultBean;
import com.neuedu.office.entity.Department;
import com.neuedu.office.service.DepartmentService;


@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping(value = "department/{id}")
	public String detail(@PathVariable("id")String id,Model model) {
		Department department = departmentService.selectById(id);
		ResultBean resultBean = new ResultBean(200,true,"查询成功。。。",department);
		model.addAttribute("office",resultBean);
		return "department_update";
	}
	
	@GetMapping(value = "department/list")
	public String list(Model model) {
		List<Department> departments = departmentService.selectAll();
		ResultBean r = new ResultBean(200,true,"显示所有部门信息成功",departments);
		model.addAttribute("office",r);
		return "departments";
	}
	
	@GetMapping(value = "department/find")
	public String find(String id,String name,String type,Model model) {
		List<Department> departments = departmentService.findbyIdNameType(id, name, type);
		ResultBean r = new ResultBean(200,true,"显示部门信息成功",departments);
		model.addAttribute("office",r);
		return "departments";
	}
	
	@GetMapping(value = "department/department_insert")
	public String department_insert() {
		return "department_insert";
	}
	
	@PostMapping(value = "department/insert")
	@ResponseBody
	public ResultBean insert(@Validated Department department,BindingResult bindingResult) {
		ResultBean r = new ResultBean();
		if (bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getField()+": "+f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5004,false,msg.toString(),null);
//			r = new ResultBean(5004,false,"部门新增失败。。。",bindingResult.getFieldErrors());
			return r;
		}
		boolean flag = departmentService.insert(department);
		if (flag) {
			r = new ResultBean(200,true,"新增部门成功,编号为:"+department.getId(),null);
		}else {
			r = new ResultBean(500,false,"新增部门失败",null);
		}
		return r;
	}
	
	@PutMapping(value = "department/update/{id}")
	@ResponseBody
	public ResultBean update(@PathVariable("id")String id,@Validated Department department,BindingResult bindingResult) {
		ResultBean r = new ResultBean();
		if (bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getField()+": "+f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5004,false,msg.toString(),null);
			return r;
		}
		boolean flag = departmentService.update(department);
		if (flag) {
			r = new ResultBean(200,true,"修改部门成功",null);
		}else {
			r = new ResultBean(500,false,"修改部门失败",null);
		}
		return r;
	}
	
	@DeleteMapping(value = "department/delete/{id}")
	@ResponseBody
	public ResultBean delete(@PathVariable("id")String id) {
		boolean flag = departmentService.delete(id);
		ResultBean r = null;
		if (flag) {
			r = new ResultBean(200,true,"删除部门成功",null);
		}else {
			r = new ResultBean(500,false,"删除部门失败",null);
		}
		return r;
	}
	
	@DeleteMapping(value = "department/batchdelete/{ids}")
	@ResponseBody
	public ResultBean batchdelete(@PathVariable("ids")String ids) {
		System.out.println(ids);
		String[] idlist = ids.split(",");
		boolean flag = departmentService.batchDelete(idlist);
		ResultBean r = null;
		if (flag) {
			r = new ResultBean(200,true,"删除部门成功",null);
		}else {
			r = new ResultBean(500,false,"删除部门失败",null);
		}
		return r;
	}
}

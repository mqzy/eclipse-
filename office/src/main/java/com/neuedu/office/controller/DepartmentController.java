package com.neuedu.office.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.office.bean.ResultBean;
import com.neuedu.office.entity.Department;
import com.neuedu.office.service.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(tags = "部门信息控制器")
@Controller
//@RequestMapping(value = "department")
@RestController(value = "department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
//	@ApiOperation(value = "显示所有部门信息页面")
//	@GetMapping(value = "/list")
//	public String list(Model model) {
//		List<Department> departments = departmentService.selectAll();
//		ResultBean r = new ResultBean(200,true,"显示所有部门信息成功",departments);
//		model.addAttribute("office",r);
//		return "departments";
//	}
	
	@ApiOperation(value = "显示所有部门信息页面")
	@GetMapping(value = "/list")
	//@ResponseBody
	public ResultBean list() {
		List<Department> departments = departmentService.selectAll();
		ResultBean r = new ResultBean(200,true,"显示所有部门信息成功",departments);
		return r;
	}
	
	@ApiOperation(value = "根据编号，名称，类型，组合模糊查询")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(paramType = "query",name = "id",value = "编号",dataType = "String"),
			@ApiImplicitParam(paramType = "query",name = "name",value = "名称",dataType = "String"),
			@ApiImplicitParam(paramType = "query",name = "type",value = "类型",dataType = "String")
	})
	@GetMapping(value = "/find")
	//@ResponseBody
	public ResultBean find(String id,String name,String type) {
		List<Department> departments = departmentService.findbyIdNameType(id, name, type);
		ResultBean r = new ResultBean(200,true,"显示部门信息成功",departments);	
		return r;
	}
	
//	@GetMapping(value = "/department_insert")
//	public String department_insert() {
//		return "department_insert";
//	}
	
	@PostMapping(value = "/insert")
	//@ResponseBody
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
	
	@ApiOperation(value = "根据编号查询")
	@ApiImplicitParam(paramType = "query",name = "id",value = "编号",dataType = "String",required = true)
	@ApiResponse(code = 200,message = "返回department_update页面")
	@GetMapping(value = "/{id}")
	//@ResponseBody
	public ResultBean detail(@PathVariable("id")String id) {
		System.out.println("id:"+id);
		Department department = departmentService.selectById(id);
		ResultBean r = new ResultBean(200,true,"查询成功。。。",department);
		return r;
	}
	
	@PutMapping(value = "/update/{id}")
	//@ResponseBody
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
	
	@DeleteMapping(value = "/delete/{id}")
	//@ResponseBody
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
	
	@DeleteMapping(value = "/batchdelete/{ids}")
	//@ResponseBody
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

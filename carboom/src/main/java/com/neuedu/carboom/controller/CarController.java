package com.neuedu.carboom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.carboom.bean.ResultBean;
import com.neuedu.carboom.entity.Car;
import com.neuedu.carboom.service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService carService;
	
	@RequestMapping(value = "createCar",method = RequestMethod.GET)
	public String creatCar() {
		return "createCar";
	}
	
	@RequestMapping(value = "find",method = RequestMethod.GET)
	public String findStation(Integer id,String name,String type,Model model) {
		List<Car> cars = carService.findByCondition(id, name, type);
		ResultBean<List<Car>> resultBean = new ResultBean<List<Car>>(200,true,"查询所有车辆成功",cars);
		model.addAttribute("car",resultBean);
		return "index";
	}
	
	@RequestMapping(value = "delete",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> deleteStation(@RequestParam("ids[]")Integer[] ids) {
		boolean flag = carService.batchDelete(ids);
		ResultBean<String> resultBean = new ResultBean<String>();
		if (flag) 
			resultBean = new ResultBean<String>(200,true,"删除车辆成功");
		else
			resultBean = new ResultBean<String>(500,false,"删除车辆失败");		
		return resultBean;
	}
	
	@RequestMapping(value = "insert",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> insert(Car car){
		System.out.println(car);
		boolean flag = carService.insert(car);
		ResultBean<String> resultBean = new ResultBean<String>();
		if (flag) {
			resultBean.setCode(200);
			resultBean.setSuccessed(true);
			resultBean.setMessage("新增车辆成功,编号为："+car.getId());
		}else {
			resultBean.setCode(500);
			resultBean.setSuccessed(false);
			resultBean.setMessage("新增车辆失败");
		}
		return resultBean;
	}
	
	@RequestMapping(value = "updateCar",method = RequestMethod.GET)
	public String updatePost(Integer id,Model model) {
		Car car = carService.selectById(id);
		model.addAttribute("car", new ResultBean<Car>(200,true,"查询成功",car));
		return "updateCar";
	}
	
	@RequestMapping(value = "update",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> update(Car car){
		boolean flag = carService.update(car);
		ResultBean<String> resultBean = new ResultBean<String>();
		if (flag) {
			resultBean.setCode(200);
			resultBean.setSuccessed(true);
			resultBean.setMessage("修改车辆成功");
		}else {
			resultBean.setCode(500);
			resultBean.setSuccessed(false);
			resultBean.setMessage("修改车辆失败");
		}
		return resultBean;
	}
}

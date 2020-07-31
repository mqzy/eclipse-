package com.neuedu.carboom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neuedu.carboom.bean.ResultBean;
import com.neuedu.carboom.entity.Car;
import com.neuedu.carboom.service.CarService;


@Controller
public class IndexController {
	@Autowired
	private CarService carService;

	@RequestMapping(value = {"","/","index"},method = RequestMethod.GET)
	public String  index(Model model) {
		List<Car> stations = carService.selectAll();
		ResultBean<List<Car>> resultBean = new ResultBean<List<Car>>(200,true,"查询所有岗位成功",stations);
		model.addAttribute("car",resultBean);
		return "index";
	}
	
	@RequestMapping(value = "top",method = RequestMethod.GET)
	public String top() {
		return "top";
	}
}
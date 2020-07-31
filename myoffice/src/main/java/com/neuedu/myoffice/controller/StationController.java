package com.neuedu.myoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.myoffice.bean.ResultBean;
import com.neuedu.myoffice.entity.Station;
import com.neuedu.myoffice.service.StationService;

@Controller
public class StationController {
	@Autowired
	private StationService stationService;

	@RequestMapping(value = "post/managerPost",method = RequestMethod.GET)
	public String managerPost(Model model) {
		List<Station> stations = stationService.selectAll();
		ResultBean<List<Station>> resultBean = new ResultBean<List<Station>>(200,true,"查询所有岗位成功",stations);
		model.addAttribute("station",resultBean);
		return "post/managerPost";
	}
	
	@RequestMapping(value = "post/find",method = RequestMethod.GET)
	public String findStation(String id,String name,String type,Model model) {
		List<Station> stations = stationService.findByCondition(id, name, type);
		ResultBean<List<Station>> resultBean = new ResultBean<List<Station>>(200,true,"查询所有岗位成功",stations);
		model.addAttribute("station",resultBean);
		return "post/managerPost";
	}
	
	@RequestMapping(value = "post/delete",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> deleteStation(@RequestParam("ids[]")String[] ids) {
		boolean flag = stationService.batchDelete(ids);
		ResultBean<String> resultBean = new ResultBean<String>();
		if (flag) 
			resultBean = new ResultBean<String>(200,true,"删除岗位成功");
		else
			resultBean = new ResultBean<String>(500,false,"删除岗位失败");		
		return resultBean;
	}
	
	@RequestMapping(value = "post/createPost",method = RequestMethod.GET)
	public String createDepartment() {
		return "post/createPost";
	}
	
	@RequestMapping(value = "post/insert",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> insert(Station station){
		boolean flag = stationService.insert(station);
		ResultBean<String> resultBean = new ResultBean<String>();
		if (flag) {
			resultBean.setCode(200);
			resultBean.setSuccessed(true);
			resultBean.setMessage("新增岗位成功,编号为："+station.getId());
		}else {
			resultBean.setCode(500);
			resultBean.setSuccessed(false);
			resultBean.setMessage("新增岗位失败");
		}
		return resultBean;
	}
	
	@RequestMapping(value = "post/updataPost",method = RequestMethod.GET)
	public String updatePost(String id,Model model) {
		Station station = stationService.selectById(id);
		model.addAttribute("station", new ResultBean<Station>(200,true,"查询成功",station));
		return "post/updataPost";
	}
	
	@RequestMapping(value = "post/update",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> update(Station station){
		boolean flag = stationService.update(station);
		ResultBean<String> resultBean = new ResultBean<String>();
		if (flag) {
			resultBean.setCode(200);
			resultBean.setSuccessed(true);
			resultBean.setMessage("修改岗位成功");
		}else {
			resultBean.setCode(500);
			resultBean.setSuccessed(false);
			resultBean.setMessage("修改岗位失败");
		}
		return resultBean;
	}
}

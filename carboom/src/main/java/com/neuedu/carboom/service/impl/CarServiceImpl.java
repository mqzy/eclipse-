package com.neuedu.carboom.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.carboom.dao.CarMapper;
import com.neuedu.carboom.entity.Car;
import com.neuedu.carboom.service.CarService;



@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarMapper carMapper;

	@Override
	public Car selectById(Integer id) {
		if (id == null) {
			return null;
		}
		return carMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Car> selectAll() {
		return carMapper.selectAll();
	}

	@Override
	public List<Car> findByCondition(Integer id, String name, String type) {
		if (id != null && id < 1) {
				id = null;
		}
		if(name != null) {
			name = name.trim();
			if (name.length() == 0) {
				name = null;
			}
		}
		if(type != null) {
			type = type.trim();
			if (type.length() == 0) {
				type = null;
			}
		}
		return carMapper.findByCondition(id, name, type);
	}

	@Override
	public boolean insert(Car car) {
		if (car == null) {
			return false;
		}
		//非空属性判断
		if (StringUtils.isAnyBlank(car.getName())||StringUtils.isBlank(car.getType())) {
			return false;
		}
		int line = carMapper.insertSelective(car);
		if (line == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Car car) {
		int line = carMapper.updateByPrimaryKeySelective(car);
		if (line == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean batchDelete(Integer[] ids) {
		if (ids == null||ids.length == 0) {
			return false;
		}
		for (Integer id : ids) {
			if (id <= 0) {
				return false;
			}
		}
		int line = carMapper.batchDelete(ids);
		if(line > 0)
			return true;
		return false;
	}


}

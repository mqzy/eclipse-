package com.neuedu.carboom.service;

import java.util.List;

import com.neuedu.carboom.entity.Car;

public interface CarService {
	Car selectById(Integer id);
	List<Car> selectAll();
	List<Car> findByCondition(Integer id,String name,String type);
	boolean insert(Car car);
	boolean update(Car car);
	boolean batchDelete(Integer[] ids);
}

package com.neuedu.myoffice.service;

import java.util.List;

import com.neuedu.myoffice.entity.Department;

public interface DepartmentService {
	Department selectById(String id);
	List<Department> selectAll();
	List<Department> findByCondition(String id,String name,String type);
	boolean insert(Department department);
	boolean update(Department department);
	boolean batchDelete(String[] ids);
}

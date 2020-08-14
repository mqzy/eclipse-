package com.neuedu.office.service;

import java.util.List;

import com.neuedu.office.entity.Department;

/**
 * 业务逻辑层接口
 * @author 姚季
 *
 */
public interface DepartmentService {
	
	boolean insert(Department department);
	
	boolean update(Department department);
	
	boolean delete(String id);
	
	Department selectById(String id);
	
	List<Department> selectAll();
	
	List<Department> findbyIdNameType(String id,String name,String type);
	
	boolean batchDelete(String[] ids);
}

package com.neuedu.myoffice.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.myoffice.dao.DepartmentMapper;
import com.neuedu.myoffice.entity.Department;
import com.neuedu.myoffice.service.DepartmentService;

/**
 * 业务逻辑接口 DepartmentService实现类DepartmentServiceImpl：实现接口中的所有方法
 * @author 姚季
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public Department selectById(String id) {
		if (id == null) {
			return null;
		}
		return departmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Department> selectAll() {
		return departmentMapper.selectAll();
	}

	@Override
	public boolean insert(Department department) {
		//业务逻辑验证
		//部门对象不能为空
		if (department == null) {
			return false;
		}
		//非空属性判断
		if (StringUtils.isAnyBlank(department.getName())||StringUtils.isBlank(department.getType())||
				StringUtils.isBlank(department.getTelephone())||department.getDate() == null) {
			return false;
		}
		int line = departmentMapper.insertSelective(department);
		if (line == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Department department) {
		int line = departmentMapper.updateByPrimaryKeySelective(department);
		if (line == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean batchDelete(String[] ids) {
		return false;
	}

	@Override
	public List<Department> findByCondition(String id, String name, String type) {
		if (id != "" && Integer.parseInt(id) < 1) {
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
		return departmentMapper.findByCondition(id, name, type);
	}

}

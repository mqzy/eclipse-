package com.neuedu.office.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.office.dao.DepartmentMapper;
import com.neuedu.office.entity.Department;
import com.neuedu.office.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	@Override
	public boolean insert(Department department) {
		int line = departmentMapper.insertSelective(department);
		return line==1?true:false;
	}

	@Override
	public boolean update(Department department) {
		int line = departmentMapper.updateByPrimaryKeySelective(department);
		return line==1?true:false;
	}

	@Override
	public boolean delete(String id) {
		int line = departmentMapper.deleteByPrimaryKey(id);
		return line==1?true:false;
	}

	@Override
	public Department selectById(String id) {
		return departmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Department> selectAll() {
		return departmentMapper.selectAll();
	}

	@Override
	public List<Department> findbyIdNameType(String id, String name, String type) {
		if (id != ""&&Integer.parseInt(id)<1) {
			id = null;
		}
		if (StringUtils.isBlank(name)) {
			name = null;
		}
		if (StringUtils.isBlank(type)) {
			type = null;
		}
		return departmentMapper.findByCondition(id, name, type);
	}

	@Override
	public boolean batchDelete(String[] ids) {
		return departmentMapper.batchDelete(ids)>0?true:false;
	}
 
}

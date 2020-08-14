package com.neuedu.office.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.office.entity.Department;

@SpringBootTest
public class OfficeDaoTest {
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Test
	public void test_selectByPrimaryKey() {
		String id = "1";
		Department department = departmentMapper.selectByPrimaryKey(id);
		Assertions.assertEquals(id, department.getId());
	}
}

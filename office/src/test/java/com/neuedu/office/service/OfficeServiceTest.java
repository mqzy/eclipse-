package com.neuedu.office.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.office.entity.Department;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class OfficeServiceTest {
	@Autowired
	private DepartmentService departmentService;
	
	@Test
	void test_selectByid() {
		String id = "1";
		Department department = departmentService.selectById(id);
		assertEquals(id, department.getId());
	}
}
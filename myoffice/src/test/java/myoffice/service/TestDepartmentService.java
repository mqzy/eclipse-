package myoffice.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.neuedu.myoffice.entity.Department;
import com.neuedu.myoffice.service.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:mybatis-config.xml","classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class TestDepartmentService {
	@Autowired
	private DepartmentService departmentService;
	
	@Test
	public void testSelectById() {
		String id = "2";
		Department department = departmentService.selectById(id);
		assertEquals("selectById 测试失败了~~~", id,department.getId());
	}

	@Test
	public void testSelectAll() {
		List<Department> departments = departmentService.selectAll();
		assertEquals("selectAll 测试失败了~~~",3,departments.size());
	}

	@Test
	public void testInsert() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Department department = new Department("34","睡觉部","部门","123","xx","2","什么部",sdf.parse("2018-08-18"));
		boolean flag = departmentService.insert(department);
		assertEquals("insert 测试失败了~~~",true,flag);
	}

	@Test
	public void testUpdate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Department department = new Department("34","睡觉部","部门","123","hh","2","什么部",sdf.parse("2018-08-18"));
		boolean flag = departmentService.update(department);
		assertEquals("update 测试失败了~~~",true,flag);
	}
	
	@Test
	public void testBatchDelete() {
		fail("Not yet implemented");
	}

}

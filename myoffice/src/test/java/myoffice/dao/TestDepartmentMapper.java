package myoffice.dao;

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

import com.neuedu.myoffice.dao.DepartmentMapper;
import com.neuedu.myoffice.entity.Department;

/**
 * 数据访问层部门操作测试用例
 * 特点：解决SSM框架加载配置文件的问题
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:mybatis-config.xml","classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class TestDepartmentMapper {
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Test
	public void test_selectByPrimaryKey() {
		String id = "2";
		Department department = departmentMapper.selectByPrimaryKey(id);
		assertEquals("selectByPrimaryKey 测试失败了~~~", id,department.getId());
	}
	
	@Test
	public void test_selectAll() {
		List<Department> departments = departmentMapper.selectAll();
		assertEquals("selectAll 测试失败了~~~",4,departments.size());
	}
	
	@Test
	public void test_insertSelective() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Department department = new Department("34","睡觉部","部门","123","xx","2","什么部",sdf.parse("2018-08-18"));
		int line = departmentMapper.insertSelective(department);
		assertEquals("insertSelective 测试失败了~~~",1,line);
	}
	
	@Test
	public void test_updateByPrimaryKeySelective() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Department department = new Department("3","公关部","部门","123","hh","2","正经部",sdf.parse("2018-08-18"));
		int line = departmentMapper.updateByPrimaryKeySelective(department);
		assertEquals("updateByPrimaryKeySelective 测试失败了~~~",1,line);
	}
	
	@Test
	public void test_deleteByPrimaryKey() {
		int line = departmentMapper.deleteByPrimaryKey("34");
		assertEquals("deleteByPrimaryKey 测试失败了~~~",1,line);
	}
}

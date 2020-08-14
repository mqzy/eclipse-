package com.neuedu.office.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.office.entity.MyDepartment;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class OfficeJpaDaoTest {
	@Autowired
	private MyDepartmentRepository myDepartmentRepository;
	
	@Test
	public void test_selectByPrimaryKey() {
		String id = "1";
		Optional<MyDepartment> d = myDepartmentRepository.findById(id);
		Assertions.assertEquals(id, d.get().getId());
		log.info(d.get().toString());
		log.debug("selectByPrimaryKey测试通过");
	}
	
	@Test
	public void test_save() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		MyDepartment department = MyDepartment.builder()
				.id("10")
				.name("aaa")
				.type("公司")
				.telephone("000")
				.date(sdf.parse("2020-08-12"))
				.build();
		 MyDepartment d= myDepartmentRepository.save(department);
		log.info(d.toString());
		log.debug("save测试通过");
	}
	
	@Test
	public void test_find1() {
		List<MyDepartment> ds = myDepartmentRepository.findByNameLike("%部%");
		System.out.println(ds);
		log.debug("find1测试通过");
	}
	
	@Test
	public void test_find2() {
		List<MyDepartment> ds = myDepartmentRepository.findByNameLikeQuery("部");
		System.out.println(ds);
		log.debug("find2测试通过");
	}
}

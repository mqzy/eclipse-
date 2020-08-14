package com.neuedu.office.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neuedu.office.entity.MyDepartment;


//public interface MyDepartmentRepository extends CrudRepository<MyDepartment, String>{
//
//}

@Repository
public interface MyDepartmentRepository extends JpaRepository<MyDepartment, String>{
	List<MyDepartment> findByNameLike(String name);
	
//	@Query(nativeQuery = true,value = "select d.id,d.name,d.type,d.telephone,d.fax,d.description,d.predepartment,d.date from department d where d.name like concat ('%',?1,'%')")
//	List<MyDepartment> findByNameLikeQuery(@Param("name")String name);
	
	@Query(value = "from department d where d.name like concat ('%',:name,'%')")
	List<MyDepartment> findByNameLikeQuery(@Param("name")String name);
}
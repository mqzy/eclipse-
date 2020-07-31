package com.neuedu.myoffice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.myoffice.entity.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    List<Department> selectAll();
    
    List<Department> findByCondition(@Param("id")String id,@Param("name")String name,@Param("type")String type);
}
package com.neuedu.myoffice.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.neuedu.myoffice.entity.Management;

@Repository
public interface ManagementMapper {
    int deleteByPrimaryKey(String id);

    int insert(Management record);

    int insertSelective(Management record);

    Management selectByPrimaryKey(String id);
    
    Management login(@Param("name")String name,@Param("password")String password);

    int updateByPrimaryKeySelective(Management record);

    int updateByPrimaryKey(Management record);
}
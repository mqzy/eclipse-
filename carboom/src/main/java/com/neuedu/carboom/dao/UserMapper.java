package com.neuedu.carboom.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.neuedu.carboom.entity.User;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User login(@Param("username")String name,@Param("password")String password);
}
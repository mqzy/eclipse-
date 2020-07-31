package com.neuedu.carboom.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.neuedu.carboom.entity.Car;

@Repository
public interface CarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    List<Car> selectAll();
    
    List<Car> findByCondition(@Param("id")Integer id,@Param("name")String name,@Param("type")String type);
    
    int batchDelete(Integer[] ids);
}
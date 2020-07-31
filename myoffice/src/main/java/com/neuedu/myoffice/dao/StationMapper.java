package com.neuedu.myoffice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.neuedu.myoffice.entity.Station;

@Repository
public interface StationMapper {
    int deleteByPrimaryKey(String id);

    int insert(Station record);

    int insertSelective(Station record);

    Station selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Station record);

    int updateByPrimaryKey(Station record);
    
    List<Station> selectAll();
    
    List<Station> findByCondition(@Param("id")String id,@Param("name")String name,@Param("type")String type);
    
    int batchDelete(String[] ids);
}
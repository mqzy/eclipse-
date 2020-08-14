package com.neuedu.office.dao;

import com.neuedu.office.entity.Department;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

@Mapper
@CacheNamespace
public interface DepartmentMapper {
    @Delete({
        "delete from department",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @DeleteProvider(type = DepartmentSqlProvider.class,method = "batchDelete")
    int batchDelete(String[] ids);
    
    @Insert({
        "insert into department (id, name, ",
        "type, telephone, ",
        "fax, description, ",
        "predepartment, date)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{telephone,jdbcType=VARCHAR}, ",
        "#{fax,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{predepartment,jdbcType=VARCHAR}, #{date,jdbcType=DATE})"
    })
    int insert(Department record);

    @Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
    @InsertProvider(type=DepartmentSqlProvider.class, method="insertSelective")
    int insertSelective(Department record);

    @Select({
        "select",
        "id, name, type, telephone, fax, description, predepartment, date",
        "from department",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="fax", property="fax", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="predepartment", property="predepartment", jdbcType=JdbcType.VARCHAR),
        @Result(column="date", property="date", jdbcType=JdbcType.DATE)
    })
    Department selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, name, type, telephone, fax, description, predepartment, date",
        "from department"
    })
    List<Department> selectAll();
    
    @SelectProvider(type = DepartmentSqlProvider.class,method = "findByCondition")
    List<Department> findByCondition(@Param("id")String id,@Param("name")String name,@Param("type")String type);
    
    @UpdateProvider(type=DepartmentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Department record);

    @Update({
        "update department",
        "set name = #{name,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "telephone = #{telephone,jdbcType=VARCHAR},",
          "fax = #{fax,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "predepartment = #{predepartment,jdbcType=VARCHAR},",
          "date = #{date,jdbcType=DATE}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Department record);
}
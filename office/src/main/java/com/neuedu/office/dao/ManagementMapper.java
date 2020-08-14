package com.neuedu.office.dao;

import com.neuedu.office.entity.Management;

import ch.qos.logback.core.net.LoginAuthenticator;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

@Mapper
@CacheNamespace
public interface ManagementMapper {
    @Delete({
        "delete from management",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into management (id, password, ",
        "name)",
        "values (#{id,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR})"
    })
    int insert(Management record);

    @InsertProvider(type=ManagementSqlProvider.class, method="insertSelective")
    int insertSelective(Management record);

    @Select({
        "select",
        "id, password, name",
        "from management",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Management selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, password, name",
        "from management",
        "where name = #{name} and password = #{password}"
    })
    Management login(@Param("name")String name,@Param("password")String password);
    
    @UpdateProvider(type=ManagementSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Management record);

    @Update({
        "update management",
        "set password = #{password,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Management record);
}
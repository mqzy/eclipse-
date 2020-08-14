package com.neuedu.office.dao;

import com.neuedu.office.entity.Department;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class DepartmentSqlProvider {

    public String insertSelective(Department record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("department");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            sql.VALUES("telephone", "#{telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getFax() != null) {
            sql.VALUES("fax", "#{fax,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getPredepartment() != null) {
            sql.VALUES("predepartment", "#{predepartment,jdbcType=VARCHAR}");
        }
        
        if (record.getDate() != null) {
            sql.VALUES("date", "#{date,jdbcType=DATE}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Department record) {
        SQL sql = new SQL();
        sql.UPDATE("department");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            sql.SET("telephone = #{telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getFax() != null) {
            sql.SET("fax = #{fax,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getPredepartment() != null) {
            sql.SET("predepartment = #{predepartment,jdbcType=VARCHAR}");
        }
        
        if (record.getDate() != null) {
            sql.SET("date = #{date,jdbcType=DATE}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
    
    public String findByCondition(String id,String name,String type) {
    	SQL sql = new SQL();
    	sql.SELECT("id, name, type, telephone, fax, description, predepartment, date");
    	sql.FROM("department");
    	if (id != null) {
			sql.WHERE(" id like concat('%',#{id},'%')");
		}
    	if (name != null) {
			sql.WHERE(" name like concat('%',#{name},'%')");
		}
    	if (type != null) {
			sql.WHERE(" type like concat('%',#{type},'%')");
		}
    	return sql.toString();
    }
    
    public String batchDelete(Map map) {
    	String[] ids = (String[]) map.get("array");
		StringBuffer sql = new StringBuffer("delete from department where id in (");
		for (int i = 0; i < ids.length; i++) {
			if (i < ids.length-1) {
				sql.append(ids[i]+",");
			}else {
				sql.append(ids[i]+")");
			}
		}
		return sql.toString();
	}
}
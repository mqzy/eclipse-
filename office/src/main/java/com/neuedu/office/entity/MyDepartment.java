package com.neuedu.office.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "department")
@Table(name = "department")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyDepartment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6709104634770922302L;
	@Id
	private String id;
	private String name;
	private String type;
	private String telephone;
	private String fax;
	private String description;
	private String predepartment;
	private Date date;
	
}

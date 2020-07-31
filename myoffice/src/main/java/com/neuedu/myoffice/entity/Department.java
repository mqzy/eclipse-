package com.neuedu.myoffice.entity;

import java.io.Serializable;
import java.util.Date;

public class Department implements Serializable{
	
	private static final long serialVersionUID = -2748407609723003626L;
	/**
	 * 编号
	 */
    private String id;

    private String name;

    private String type;

    private String telephone;

    private String fax;

    private String description;

    private String predepartment;

    private Date date;

    public Department(String id, String name, String type, String telephone, String fax, String description, String predepartment, Date date) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.telephone = telephone;
        this.fax = fax;
        this.description = description;
        this.predepartment = predepartment;
        this.date = date;
    }

    public Department() {
        super();
    }

    @Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", type=" + type + ", telephone=" + telephone + ", fax="
				+ fax + ", description=" + description + ", predepartment=" + predepartment + ", date=" + date + "]";
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPredepartment() {
        return predepartment;
    }

    public void setPredepartment(String predepartment) {
        this.predepartment = predepartment == null ? null : predepartment.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
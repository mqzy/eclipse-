package com.neuedu.myoffice.entity;

import java.io.Serializable;

public class Management implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String password;

    private String name;

    public Management(String password, String name) {
        this.name = name;
        this.password = password;
    }

    public Management(String id,String password, String name) {
        this(password,name);
        this.id = id;
    }
    
    public Management() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "Management [id=" + id + ", password=" + password + ", name=" + name + "]";
	}
    
    
}
package com.neuedu.carboom.bean;

import java.io.Serializable;

/**
 * 同意返回数据类型
 * @author 姚季
 *
 */

public class ResultBean <T> implements Serializable{
	private static final long serialVersionUID = -2748407609723003626L;
	private Integer code;
	private boolean successed;
	private String message;
	private T data;
	
	public ResultBean() {
	}
	
	public ResultBean(Integer code, boolean successed, String message) {
		this.code = code;
		this.successed = successed;
		this.message = message;
	}

	public ResultBean(Integer code, boolean successed, String message, T data) {
		this(code,successed,message);
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public boolean isSuccessed() {
		return successed;
	}
	public void setSuccessed(boolean successed) {
		this.successed = successed;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}

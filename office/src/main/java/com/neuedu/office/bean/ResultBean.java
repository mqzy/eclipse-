package com.neuedu.office.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1772921342406994793L;
	private Integer code;
	private boolean successed;
	private String message;
	private Object data;
}

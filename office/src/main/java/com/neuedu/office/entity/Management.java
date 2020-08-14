package com.neuedu.office.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Management implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8360042214917255196L;

	private String id;

	@NotBlank(message = "登录密码不能为空")
	@Length(min = 6,message = "登录密码不能少于六位")
    private String password;
	
	@NotBlank(message = "登录名称不能为空")
	@Length(min = 4,message = "登录名称不能少于四位")
    private String name;

}
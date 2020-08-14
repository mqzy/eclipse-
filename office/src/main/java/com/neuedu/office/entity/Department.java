package com.neuedu.office.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "部门信息")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {
	private String id;

    @NotBlank
    @Length(min = 2,message = "名称长度至少2个字符")
    private String name;

    @NotBlank(message = "类型不能为空")
    private String type;

    @NotBlank
    @Pattern(regexp = "^\\d{3,4}-\\d{8}$",message = "电话格式不合法")
    private String telephone;

    private String fax;

    private String description;

    private String predepartment;

    private Date date;

	private static final long serialVersionUID = -8784823107171345387L;
}
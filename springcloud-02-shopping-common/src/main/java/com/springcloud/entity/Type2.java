package com.springcloud.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data				//生成get set hashCode toString方法
@NoArgsConstructor //无参构�?�方�?
@AllArgsConstructor//有参构�?�方�?
public class Type2  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5842673399667063571L;

	private Integer type2Id;

	private String type2Name;

	private Integer type1Id;

	private String remark;

	}
package com.springcloud.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data				//生成get set hashCode toString方法
@NoArgsConstructor //无参构造方法
@AllArgsConstructor//有参构造方法
public class Type1 implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4571440371870746434L;

	private Integer type1Id;

    private String type1Name;

    private Integer type1Number;

    private String remark;

    public Integer getType1Id() {
        return type1Id;
    }

    public void setType1Id(Integer type1Id) {
        this.type1Id = type1Id;
    }

    public String getType1Name() {
        return type1Name;
    }

    public void setType1Name(String type1Name) {
        this.type1Name = type1Name;
    }

    public Integer getType1Number() {
        return type1Number;
    }

    public void setType1Number(Integer type1Number) {
        this.type1Number = type1Number;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
package com.springcloud.config;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods implements Serializable,UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = -746799047131074998L;

	/**
	 * 商品id
	 */
    private Integer goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格
     */
    private Double goodsPrice;

    /**
     * 商品折扣价
     */
    private Double goodsDiscount;

    /**
     * 商品状态（0为下架，1为缺货，2为在售）
     */
    private Integer goodsStatus;

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 是否新品（0为新品，1为非新品）
     */
    private Integer goodsIsNew;

    /**
     * 是否热卖（0为热卖，1为非热卖）
     */
    private Integer goodsIsHot;

    /**
     * 商品级别（0为差，1为一般，2为优良）
     */
    private Integer goodsLevel;

    /**
     * 商品简介
     */
    private String goodsDecribe;

    /**
     * 商品详情
     */
    private String goodsDetails;

    /**
     * 商品图片
     */
    private String goodsImage;

    /**
     * 类别2id
     */
    private Integer type2Id;

    /**
     * 类别1id
     */
    private Integer type1Id;
    /**
     * 商品价格的最低价
     */
    private Integer goodsPriceMin;
    
    /**
     * 商品价格的最高价
     */
    private Integer goodsPriceMax;
    
    /**
     * 用于保存商品销售的数量
     */
    private Integer goodsSum;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
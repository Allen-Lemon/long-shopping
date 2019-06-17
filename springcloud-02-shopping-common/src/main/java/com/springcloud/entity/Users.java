package com.springcloud.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于展示user表中一行的数据
 */
@Entity
@Table(name = "user")
@Data  //添加get set方法以及tosting方法跟hashcode方法
@NoArgsConstructor 
@AllArgsConstructor
public class Users implements Serializable{

	
	private static final long serialVersionUID = 1L;
   /**
    * 用户id,设置id自增长
    */
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	/*
	 * 用户姓名
	 */
	@Column(name = "user_name")
	private String userName;
	
	/**
	 * 用户身份证号
	 */
	@Column(name = "user_identity")
	private long userIdentity;
	
	/**
	 * 用户密码
	 */
	@Column(name = "user_password")
	private String userPassword;
	
	/**
	 * 用户性别 ：0男，1女
	 */
	@Column(name = "user_sex")
	private Integer userSex;
	
	/**
	 * 用户电话
	 */
	@Column(name = "user_phone")
	private long userPhone;
	
	/**
	 * 用户地址
	 */
	@Column(name = "user_address")
	private String userAddress;
	
	/**
	 * 用户的出生日期
	 * yyyy-MM-dd HH:mm:ss
	 */
	@Column(name = "user_birthday")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date userBirthday;
	
	/**
	 * 用户的邮箱
	 */
	@Column(name = "user_email")
	private String userEmail;
	
	/**
	 * 用户的头像
	 */
	@Column(name = "user_image")
	private String userImage;
	
	/**
	 * 用户的权限
	 */
	@Column(name = "authority_id")
	private Integer authorityId;
	
	/**
	 * 用户的状态：0表示用户正常，1用户锁定
	 */
	@Column(name = "user_status")
	private Integer userStatus;
	
	/**
	 * user_id
user_name
user_identity
user_password
user_sex
user_phone
user_address
user_bithday
user_email
user_image
authority_id
user_status

	 */
}

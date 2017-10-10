package com.test.springboot.info.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfo {

	/**
	 * 用户ID 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true ,nullable = false)
	private Integer id;
	
	/**
	 * 用户姓名
	 */
	@Column(name = "name" ,nullable = false)
	private String name;
	
	/**
	 * 用户年龄
	 */
	@Column(name = "age")
	private Integer age;
	
	/**
	 * 用户性别
	 */
	@Column(name = "sex")
	private String sex;
	
	/**
	 * 身份证号
	 */
	@Column(name = "id_number")
	private String idNumber;
	
	/**
	 * 个人照片(地址引用)
	 */
	@Column(name = "image" )
	private String image;
	
	/**
	 * 数据添加时间
	 */
	@Column(name = "create_time")
	private Date createTime;
	
	/**
	 * 最近一次修改时间
	 */
	@Column(name = "last_modify_time")
	private Date lastModifyTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	
}

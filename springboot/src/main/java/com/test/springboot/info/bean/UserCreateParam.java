package com.test.springboot.info.bean;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户信息添加 bean 
 * 
 * @author chenwenjie
 * @since 2017-10-09
 */
public class UserCreateParam {

	/**
	 * 姓名
	 */
	@NotEmpty
	private String name;
	
	/**
	 * 年龄
	 */
	private Integer age;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 身份证号
	 */
	private String idNumber;
	
	/**
	 * 个人照片(以地址引用)
	 */
	private String image;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "UserCreateParam [name=" + name + ", age=" + age + ", sex=" + sex + ", idNumber=" + idNumber + ", image="
				+ image + "]";
	}
	
}

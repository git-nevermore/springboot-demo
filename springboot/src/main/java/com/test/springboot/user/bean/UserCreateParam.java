package com.test.springboot.user.bean;

import javax.validation.constraints.NotNull;

/**
 * 创建用户参数
 * @author chenwenjie
 * @since 2017-10-09
 */
public class UserCreateParam {

	private String username;
	private String password;
	private String nickname;
	private String type;

	public UserCreateParam() {
		super();
	}

	public UserCreateParam(String username, String password, String nickname, String type) {
		super();
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.type = type;
	}

	@NotNull
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@NotNull
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

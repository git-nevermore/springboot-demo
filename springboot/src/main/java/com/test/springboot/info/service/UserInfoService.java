package com.test.springboot.info.service;

import java.util.List;

import com.test.springboot.info.bean.UserCreateParam;
import com.test.springboot.info.entity.UserInfo;
import com.test.springboot.user.bean.UserUpdateParam;

/**
 * 用户信息操作管理接口
 * 
 * @author chenwenjie
 * @since 2017-10-09
 */
public interface UserInfoService {

	/**
	 * 根据姓名获取用户
	 * @return
	 */
	UserInfo getUser(String name);
	
	/**
	 * 获取全部用户信息
	 * @return
	 */
	List<UserInfo> getAll();

	/**
	 * 创建用户
	 * @param userCreateParam
	 * @return
	 */
	UserInfo createUser(UserCreateParam userCreateParam);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	void deleteUserInfo(Integer id);

	/**
	 * 修改用户
	 * @param userUpdateParam
	 * @return
	 */
	UserInfo modifyUserInfo(UserUpdateParam userUpdateParam);

}

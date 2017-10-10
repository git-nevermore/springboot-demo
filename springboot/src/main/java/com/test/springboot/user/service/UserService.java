package com.test.springboot.user.service;

import java.util.List;

import com.test.springboot.user.bean.UserCreateParam;
import com.test.springboot.user.bean.UserQueryParam;
import com.test.springboot.user.bean.UserUpdateParam;
import com.test.springboot.user.entity.User;

/**
 * 用户注册操作管理接口
 * 
 * @author chenwenjie
 * @since 2017-10-09
 */
public interface UserService {

	/**
	 * 根据用户名获取用户
	 * @param username
	 * @return
	 */
	public User getUser(Integer id);
	
	/**
	 * 获取全部用户信息
	 * @return
	 */
	public List<User> getAll();

	/**
	 * 根据查询条件获取指定用户
	 * @param userQueryParam
	 * @return
	 */
	public List<User> getUsers(UserQueryParam userQueryParam);

	/**
	 * 创建用户
	 * @param userCreateParam
	 * @return
	 */
	public User createUser(UserCreateParam userCreateParam);

	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public User modifyUser(UserUpdateParam userUpdateParam);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public void deleteUser(Integer id);

}

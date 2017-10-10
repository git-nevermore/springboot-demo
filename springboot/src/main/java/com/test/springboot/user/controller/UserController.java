package com.test.springboot.user.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.springboot.user.bean.UserCreateParam;
import com.test.springboot.user.bean.UserLoginParam;
import com.test.springboot.user.bean.UserUpdateParam;
import com.test.springboot.user.dao.UserDao;
import com.test.springboot.user.entity.User;
import com.test.springboot.user.service.UserService;


/**
 * 用户操作管理控制层
 * 
 * @author chenwenjie
 * @since 2017-10-09
 */
@RestController
public class UserController {

	@Resource
	private UserService userService; 
	
	@Resource
	private UserDao userDao;
	
	/**
	 * 用户登录
	 * <P>简单的数据明文与数据库记录比较	 #TODO: 数据加密存储
	 * <p>缺少权限控制			OAuth2.0/ Token  	 
	 * 
	 * @param UserLoginParam
	 * @return 
	 */
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String login(@ModelAttribute @Valid UserLoginParam userLoginParam){
		User user = userDao.findByUsernameAndPassword(userLoginParam.getUsername(), userLoginParam.getPassword());
		if(user != null){
			user.setLastLoginTime(new Date());
			userDao.save(user);
			return "登录成功";
		}
		return "登录失败";
	}
	
	/**
	 * 创建用户
	 * @param userCreateParam
	 * @return
	 */
	@RequestMapping(value = "/registry" , method = RequestMethod.POST)
	public String registry(@ModelAttribute UserCreateParam userCreateParam){
		Assert.notNull(userCreateParam, "用户创建参数为空");
		userService.createUser(userCreateParam);
		return "注册成功";
	}
	
	/**
	 * 获取全部用户列表
	 * @return
	 */
	@RequestMapping(value = "/userList" , method = RequestMethod.GET)
	public List<User> getUserList(){
		return userService.getAll();
	}
	
	/**
	 * 修改用户信息
	 * <p>目前支持修改昵称和密码
	 * 
	 * @param userUpdateParam
	 * @return
	 */
	@RequestMapping(value = "/user" , method = RequestMethod.PUT)
	public User createUser(@RequestBody UserUpdateParam userUpdateParam){
		Assert.notNull(userUpdateParam, "输入参数为空");
		Assert.notNull(userUpdateParam.getId(),"用户ID 为空");
	//	return userService.modifyUser(userUpdateParam);
		return null;
	}
	
}

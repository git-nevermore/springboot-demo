package com.test.springboot.info.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.springboot.info.bean.UserCreateParam;
import com.test.springboot.info.entity.UserInfo;
import com.test.springboot.info.service.UserInfoService;
import com.test.springboot.user.bean.UserUpdateParam;

/**
 * 用户信息管理控制层
 * 
 * @author chenwenjie
 * @since 2017-10-09
 */
@RestController
public class UserInfoController {

	@Resource
	private UserInfoService userInfoService;
	
	/**
	 * 添加用户信息
	 * @param userCreateParam
	 * @return
	 */
	@RequestMapping(value = "/input" , method = RequestMethod.POST)
	public String addUserInfo(@Valid @ModelAttribute UserCreateParam userCreateParam){
		userInfoService.createUser(userCreateParam);
		return "添加成功";			//实际项目响应视图
	}
	
	/**
	 * 列出用户信息
	 * @param userCreateParam
	 * @return
	 */
	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public List<UserInfo> listUserInfo(UserCreateParam userCreateParam){
		List<UserInfo> list = userInfoService.getAll();
		//其他检查操作
		return list;			//返回列表视图
	}
	
	/**
	 * 修改用户信息
	 * @param userUpdateParam
	 * @return
	 */
	@RequestMapping(value = "/info" , method = RequestMethod.PUT)
	public UserInfo modifyUser(@RequestBody UserUpdateParam userUpdateParam){
		Assert.notNull(userUpdateParam, "输入参数为空");
		Assert.notNull(userUpdateParam.getId(),"用户ID 为空");
		return userInfoService.modifyUserInfo(userUpdateParam);
	}
	
	/**
	 * 删除用户信息
	 * 
	 * @param userUpdateParam
	 * @return
	 */
	@RequestMapping(value = "/info" , method = RequestMethod.DELETE)
	public UserInfo deleteUser(@RequestBody UserUpdateParam userUpdateParam){
		Assert.notNull(userUpdateParam, "输入参数为空");
		Assert.notNull(userUpdateParam.getId(),"用户ID 为空");
		return userInfoService.modifyUserInfo(userUpdateParam);
	}
	
	/**
	 * 导入用户信息
	 * @return
	 */
	@RequestMapping(value = "/import" , method = RequestMethod.POST)
	public void importUser(){
		//#TODO
	}
	
	/**
	 * 导出用户信息
	 * @return
	 */
	@RequestMapping(value = "/export" , method = RequestMethod.POST)
	public void exportUser(){
		//#TODO
	}
	
}

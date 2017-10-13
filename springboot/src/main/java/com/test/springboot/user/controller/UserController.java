package com.test.springboot.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.springboot.user.bean.UserCreateParam;
import com.test.springboot.user.bean.UserLoginParam;
import com.test.springboot.user.entity.User;
import com.test.springboot.user.service.UserService;

/**
 * 用户操作管理控制层
 * 
 * @author chenwenjie
 * @since 2017-10-09
 */
@Controller
public class UserController {

	@Resource
	private UserService userService; 
	
	/**
	 * 用户登录
	 * <P>简单的数据明文与数据库记录比较	 #TODO: 数据加密存储
	 * <p>缺少权限控制					 #TODO: OAuth2.0/Token  	 
	 * 
	 * @param UserLoginParam
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String login(@ModelAttribute @Valid UserLoginParam userLoginParam,HttpServletRequest request){
		User user = userService.checkLogin(userLoginParam);
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 注册用户
	 * @param userCreateParam
	 * @return
	 */
	@ResponseBody			
	@RequestMapping(value = "/registry" , method = RequestMethod.POST )
	public String registry(@ModelAttribute UserCreateParam userCreateParam){
		Assert.notNull(userCreateParam, "用户创建参数为空");
		userService.createUser(userCreateParam);
		return "注册成功 ！(没有经费做返回界面了,请自己手动后退)";
	}
	
	/**
	 * 获取全部用户列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/userList" , method = RequestMethod.GET)
	public List<User> getUserList(){
		return userService.listAll();
	}
}

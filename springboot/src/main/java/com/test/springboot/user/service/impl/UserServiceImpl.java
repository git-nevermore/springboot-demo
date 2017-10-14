package com.test.springboot.user.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.test.springboot.common.exception.BaseException;
import com.test.springboot.user.bean.UserCreateParam;
import com.test.springboot.user.bean.UserLoginParam;
import com.test.springboot.user.bean.UserQueryParam;
import com.test.springboot.user.bean.UserUpdateParam;
import com.test.springboot.user.dao.UserDao;
import com.test.springboot.user.entity.User;
import com.test.springboot.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getByName(String username) {
		Assert.notNull(username,"用户名不能为空");
		return userDao.findByUsername(username);
	}
	
	@Override
	public List<User> listAll() {
		return userDao.findAll();
	}

	@Override
	public List<User> listUsers(UserQueryParam userQueryParam) {
		return userDao.queryUsers(userQueryParam);
	}

	@Override
	public User createUser(UserCreateParam userCreateParam) {
		User user = new User();
		if(this.getByName(userCreateParam.getUsername()) != null ){
			throw new BaseException("用户名称已存在！");
		}
		user.setNickname(userCreateParam.getNickname());
		user.setUsername(userCreateParam.getUsername());
		user.setPassword(userCreateParam.getPassword());
		user.setType(userCreateParam.getType());
		user.setRegistryTime(new Date());
		return userDao.save(user);
	}

	@Override
	public User modifyUser(UserUpdateParam userUpdateParam) {
		User user = userDao.findOne(userUpdateParam.getId());
		if(user ==null){
			throw new BaseException("用户不存在");
		}
		user.setNickname(userUpdateParam.getNicknane());
		user.setPassword(userUpdateParam.getPassword());
		return userDao.save(user);
	}

	@Override
	public void deleteUser(Integer id) {
		userDao.delete(id);
	}

	@Override
	public User checkLogin(UserLoginParam userLoginParam) {
		String username = userLoginParam.getUsername();
		String password = userLoginParam.getPassword();
		if (username == null || password == null) {
			throw new BaseException("输入参数有误,账户名或密码不能为空");
		}
		return userDao.findByUsernameAndPassword(username, password);
	}

}

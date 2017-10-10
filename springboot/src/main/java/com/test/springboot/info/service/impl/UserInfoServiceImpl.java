package com.test.springboot.info.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.test.springboot.common.exception.BaseException;
import com.test.springboot.info.bean.UserCreateParam;
import com.test.springboot.info.dao.UserInfoDao;
import com.test.springboot.info.entity.UserInfo;
import com.test.springboot.info.service.UserInfoService;
import com.test.springboot.user.bean.UserUpdateParam;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoDao userInfoDao;
	
	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	
	@Override
	public List<UserInfo> getAll() {
		return userInfoDao.findAll();
	}

	@Override
	public UserInfo getUser(String name) {
		return userInfoDao.findByName(name);
	}

	@Override
	public UserInfo createUser(UserCreateParam userCreateParam) {
		//创建用户信息记录
		logger.debug("创建用户参数:" + userCreateParam);
		
		UserInfo user = new UserInfo();
		if (this.getUser(userCreateParam.getName()) != null) {
			throw new BaseException("用户名称已存在！");
		}
		user.setName(userCreateParam.getName());
		user.setAge(userCreateParam.getAge());
		user.setIdNumber(userCreateParam.getIdNumber());
		user.setSex(userCreateParam.getSex());
		user.setCreateTime(new Date());
		user.setLastModifyTime(new Date());
		return userInfoDao.save(user);
	}
	
	@Override
	public UserInfo modifyUserInfo(UserUpdateParam userUpdateParam) {
		//创建用户信息记录
		logger.debug("创建用户参数:" + userUpdateParam);
		
		UserInfo userInfo = new UserInfo();			//实体 bean 的填充
	
		//userInfoDao.save(userUpdateParam);		//采用SpringJPA 进行更新
		return null;
	}

	@Override
	public void deleteUserInfo(Integer id) {
		userInfoDao.delete(id);
	}
}

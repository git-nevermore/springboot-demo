package com.test.springboot.info.dao;

import org.springframework.stereotype.Repository;

import com.test.springboot.common.dao.BaseDao;
import com.test.springboot.info.entity.UserInfo;

@Repository
public interface UserInfoDao extends BaseDao<UserInfo, Integer>{

	/**
	 * 根据用户姓名获取用户
	 * @param username
	 * @return
	 */
	UserInfo findByName(String username);
	
}

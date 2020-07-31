package com.neuedu.carboom.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.carboom.dao.UserMapper;
import com.neuedu.carboom.entity.User;
import com.neuedu.carboom.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User login(String name, String password) {
		if(StringUtils.isAnyBlank(name)||StringUtils.isBlank(password))
			return null;
		return userMapper.login(name, password);
	}

}

package com.neuedu.myoffice.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.myoffice.dao.ManagementMapper;
import com.neuedu.myoffice.entity.Management;
import com.neuedu.myoffice.service.ManagementService;

@Service
public class ManagementServiceImpl implements ManagementService {
	@Autowired
	private ManagementMapper managementMapper;
	
	@Override
	public Management login(String name, String password) {
		if(StringUtils.isAnyBlank(name)||StringUtils.isBlank(password))
			return null;
		return managementMapper.login(name, password);
	}

}

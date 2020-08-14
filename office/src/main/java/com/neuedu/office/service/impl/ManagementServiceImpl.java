package com.neuedu.office.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.office.dao.ManagementMapper;
import com.neuedu.office.entity.Management;
import com.neuedu.office.service.ManagementService;

@Service
public class ManagementServiceImpl implements ManagementService {
	@Autowired
	private ManagementMapper managementMapper;
	
	@Override
	public Management login(String name, String password) {
		return managementMapper.login(name, password);
	}

}

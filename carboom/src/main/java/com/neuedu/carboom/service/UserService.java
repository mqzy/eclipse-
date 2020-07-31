package com.neuedu.carboom.service;

import com.neuedu.carboom.entity.User;

public interface UserService {
	User login(String name,String password);
}

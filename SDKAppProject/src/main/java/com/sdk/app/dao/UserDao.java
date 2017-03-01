package com.sdk.app.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sdk.app.model.UserInfo;

public interface UserDao {

	//public String register(UserInfo userInfo);
	
	 boolean register(UserInfo userInfo);
	
}

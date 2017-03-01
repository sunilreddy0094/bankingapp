package com.sdk.app.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.sdk.app.dao.UserDao;
import com.sdk.app.model.UserInfo;

@Controller
@RequestMapping("/")
public class MainController {
	private static final Log LOGGER = LogFactory.getLog(MainController.class);
	
	public static String dbUrl;
	public static String dbDriver;
	public static String dbUserName;
	public static String dbPassword;
	public static String dbDialect;
	
	@Autowired
	UserDao userDao;
	//@Autowired
	UserInfo userInfo;
	
	@RequestMapping(value ="/main" ,method=RequestMethod.GET)
	public String getMainLandingPage(){
		
		return "register";
	}
	@RequestMapping(value ="/register" ,method=RequestMethod.POST)
	public String getRegisterLandingPage(HttpServletRequest request, HttpServletResponse response){
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		userInfo=new UserInfo(email,password,firstName,lastName);
//		userInfo.setEmail(email);
//		userInfo.setPassword(password);
//		userInfo.setFirstName(firstName);
//		userInfo.setLastName(lastName);
//		
		userDao.register(userInfo);
		
		
		return "success";
	}
	@PostConstruct
	public void init(){
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("C:/Users/sunil/Desktop/SDKAppProject/sdkapp.properties");
			// load a properties file
			prop.load(input);
			
			dbDriver = prop.getProperty("sdk.database.driver");
			dbUrl = prop.getProperty("sdk.database.url");
			dbUserName = prop.getProperty("sdk.database.username");
			dbPassword = prop.getProperty("sdk.database.password");
			dbDialect = prop.getProperty("sdk.database.dialect");
		}catch(Exception e){
			LOGGER.error("Exception Occured While reading the Properties"+e);
			e.printStackTrace();
		}
	}

}

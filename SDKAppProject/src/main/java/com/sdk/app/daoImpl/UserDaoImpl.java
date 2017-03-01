package com.sdk.app.daoImpl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sdk.app.config.HiberanteConfiguration;
import com.sdk.app.dao.UserDao;
import com.sdk.app.model.UserInfo;
@Service("UserDao")
public class UserDaoImpl implements UserDao {
//	@Autowired
//	SessionFactory sessionFactory;
//	@Override
//	public String register(UserInfo userInfo) {
//		
//		return null;
//	}

	@Override
	public boolean register(UserInfo userInfo) {
		// TODO Auto-generated method stub
		
		Session session = HiberanteConfiguration.getSession();
		try{
		Transaction tx= session.beginTransaction();
		session.save(userInfo);
		
	tx.commit();
		}
		catch(Exception e){
			
		e.printStackTrace();
		}
		return false;
	}

}

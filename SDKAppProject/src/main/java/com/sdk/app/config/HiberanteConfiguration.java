package com.sdk.app.config;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.sdk.app.controller.MainController;
import com.sdk.app.model.UserInfo;

public class HiberanteConfiguration {
	private static final Log LOGGER = LogFactory.getLog(HiberanteConfiguration.class);
	private static SessionFactory sessionFactory;
	
	static {
		try {
			Configuration configuration= new Configuration();
			configuration.setProperty("hibernate.connection.url", MainController.dbUrl);
			configuration.setProperty("hibernate.connection.username", MainController.dbUserName);
			configuration.setProperty("hibernate.connection.password", MainController.dbPassword);
			configuration.setProperty("dialect", MainController.dbDialect);
			configuration.setProperty("hibernate.connection.driver_class", MainController.dbDriver);	
			configuration.setProperty("show_sql", "true");	
			
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			sessionFactory = configuration.addPackage("com.sdk.app.model.*").addAnnotatedClass(UserInfo.class).buildSessionFactory(builder.build());
		} catch (Exception ex) {
			LOGGER.error("Exception Occured While Configuring the Hibernate Properties" + ex);
		}
	}
	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}
}

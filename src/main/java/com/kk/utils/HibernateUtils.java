package com.kk.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.entity.Song;

public class HibernateUtils {
	
	private static SessionFactory factory=null;
	
	public  static SessionFactory getSessionFactory() throws HibernateException {
		if(factory==null) {
			try {
				Configuration configuration=new Configuration();
		    	configuration.configure("hibernate.cfg.xml");
		    	configuration.addAnnotatedClass(Song.class);
		    	
		    	//Create SessionFactory
		    	factory=configuration.buildSessionFactory();
			}catch (Exception e) {
				e.getMessage();
				System.out.println("Exception while creating SessionFactory...");
			}
		}
		return factory;
	}

}

package com.kk.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kk.hibernate.entity.Song;
import com.kk.utils.HibernateUtils;

/**
 * Hello world!
 *
 */
public class deleteApp 
{
    public static void main( String[] args )
    {
    	//Create Configuration
    	SessionFactory factory = HibernateUtils.getSessionFactory();
    	
    	//Initilize Session Object
    	Session session=factory.openSession();
        Song song=session.get(Song.class,2);
        session.beginTransaction();
        session.remove(song);
        session.getTransaction().commit();
        session.close();
    }

//	private static SessionFactory SessionFactory() {
//		Configuration configuration=new Configuration();
//    	configuration.configure("hibernate.cfg.xml");
//    	configuration.addAnnotatedClass(Song.class);
//    	
//    	//Create SessionFactory
//    	SessionFactory factory=configuration.buildSessionFactory();
//		return factory;
//	}
}

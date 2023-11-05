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
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = HibernateUtils.getSessionFactory();
    	
    	//Initilize Session Object
    	Session session=factory.openSession();
        System.out.println( "Hello World!" );
        Song song=new Song();
//        song.setSongId(3);
//        Transaction transaction=session.getTransaction();
        song.setSongName("Dharmam Gelavani Chota");
        song.setLyricist("Rama Jogayya Sasthri");
        session.beginTransaction();
        session.persist(song);
        session.getTransaction().commit();
        session.close();
        
    }

//	private static SessionFactory getSessionFactory() {
//		//Create Configuration
//    	Configuration configuration=new Configuration();
//    	configuration.configure("hibernate.cfg.xml");
//    	configuration.addAnnotatedClass(Song.class);
//    	
//    	//Create SessionFactory
//    	SessionFactory factory=configuration.buildSessionFactory();
//		return factory;
//	}
}

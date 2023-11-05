package com.kk.hibernate;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.kk.hibernate.entity.Song;
import com.kk.hibernate.util.HibernateUtil;
import com.kk.utils.HibernateUtils;

/**
 * Hello world!
 *
 */
public class readApp 
{
    public static void main( String[] args )
    {
    	//Create Configuration
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	SessionFactory factory2 = HibernateUtils.getSessionFactory();
    	System.out.println("factories :"+factory+"   "+factory2);
    	
    	//Initilize Session Object
    	Session session=factory.openSession();
    	if(session!=null) {
    		System.out.println(session.get(Song.class, 1));
    	}
    	else
    		System.out.println("Session is empty...");
    	
    	Session session2=factory.openSession();
    	session2.beginTransaction();
    	System.out.println(session2.get(Song.class, 1));
    	session2.getTransaction().commit();
    	session2.close();
    	
    	System.out.println("QUERY_CACHE");
    	Session s3=factory.openSession();
    	Query s=session.createQuery("from Song where songId=1");
    	s.setCacheable(true);
    	System.out.println("query cache :"+s.uniqueResult());
    	s3.close();
    	
    	
//    	Query query=session.createQuery("select rollnun,name from Song where rollnum=1");
//    	Object[] res=(Object[]) query.uniqueResult();
//    	System.out.println(res[0]+"    "+res[1]);
//    	for(Object obj:res) {
//    		System.out.println(res);
//    	}
    	
//    	NativeQuery createNativeQuery = session.createNativeQuery("select * from song where rollnum=1");
//    	createNativeQuery.addEntity(Song.class);
//    	Object uniqueResult = createNativeQuery.uniqueResult();
    	
    	Session s4=factory.openSession();
    	Query ss=session.createQuery("from Song where songId=1");
    	ss.setCacheable(true);
    	System.out.println("query cache :"+ss.uniqueResult());
    	s4.close();
    	
    	
    	//read
//    	List<Song> songs = session.createQuery("from song",Song.class).list();
    	
    	

    	
    	
    	//        System.out.println(session.get(Song.class, 2));// first approach to get data from db
//        System.out.println(session.load(Song.class, 2));
    }

//	private static SessionFactory getSessionFactory() {
//		Configuration configuration=new Configuration();
//    	configuration.configure("hibernate.cfg.xml");
//    	configuration.addAnnotatedClass(Song.class);
//    	
//    	//Create SessionFactory
//    	SessionFactory factory=configuration.buildSessionFactory();
//		return factory;
//	}
}

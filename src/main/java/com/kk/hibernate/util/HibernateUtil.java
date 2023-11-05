package com.kk.hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.kk.hibernate.entity.Song;
import com.kk.hibernate.relationship.Address;
import com.kk.hibernate.relationship.Employee;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			Properties properties = new Properties();
			properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			properties.put(Environment.URL, "jdbc:mysql://localhost:3306/school");
			properties.put(Environment.USER, "root");
			properties.put(Environment.PASS, "Karthik_119");
			properties.put(Environment.SHOW_SQL, true);
			properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			properties.put(Environment.HBM2DDL_AUTO, "update");
			properties.put(Environment.FORMAT_SQL, true);
			properties.put(Environment.USE_SECOND_LEVEL_CACHE, true);
			properties.put(Environment.CACHE_REGION_FACTORY, org.hibernate.cache.ehcache.internal.EhcacheRegionFactory.class);
			properties.put(Environment.USE_QUERY_CACHE, true);
			
			configuration.setProperties(properties);
			configuration.addAnnotatedClass(Song.class);
			configuration.addAnnotatedClass(Employee.class);
			configuration.addAnnotatedClass(Address.class);
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}

}

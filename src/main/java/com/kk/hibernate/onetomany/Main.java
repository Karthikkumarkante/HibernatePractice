package com.kk.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		System.out.println("MY OneToMany SessionFactory...:"+factory);
		factory.close();
	}

}

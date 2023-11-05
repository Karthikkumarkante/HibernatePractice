package com.kk.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.kk.hibernate.relationship.Address;
import com.kk.hibernate.relationship.Employee;
import com.kk.hibernate.util.HibernateUtil;

public class OneToOne {

	public static void main(String[] args) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
//		Employee employee=new Employee();
//		employee.setName("kante");
//		Address address=new Address();
//		address.setAddress("bkk");
//		employee.setAddress(address);
//		address.setEmployee(employee);
//		session.beginTransaction();
////		session.persist(address);
//		session.persist(employee);
//		session.getTransaction().commit();
//		session.close();
		
		session.beginTransaction();
		Employee employee=session.get(Employee.class,5);
		//Address address=session.get(Address.class, 1);
		
		
		/*
		 * fetch data by HQL Query
		 * Query query=session.createQuery("from Employee where id:4");
		 * System.out.println("HQL :"+query.uniqueResult());
		 * 
		 * fetch data by HQL query and dynamic field data
		 * Query query=session.createQuery("from Employee where id:id");
		 * 	query.setParameter(1, 4);y
		 * 
		 */
		
		
		
		System.out.println("Employee Details :"+employee);
		//System.out.println("Address :"+address);
		session.remove(employee);
		session.getTransaction().commit();
		session.close();
		System.out.println("My SessionFactory :"+sessionFactory);
		sessionFactory.close();
	}

}

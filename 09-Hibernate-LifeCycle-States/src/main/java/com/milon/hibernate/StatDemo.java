package com.milon.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StatDemo {
	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session= factory.openSession();
		Transaction tx = session.beginTransaction();

		// Removed object state
		
		
		//Student: Transient object state
		Student st=new Student();
		st.setId(101);
		st.setName("MILON");
		st.setCity("Dhaka");
		//---------------------
		
		// Persistent object state
		session.save(st);
		st.setName("MILON1");
		tx.commit();
		//----------------------
		
		// Detached object state
		session.close();
		//---------------------
		
		factory.close();

	}
}

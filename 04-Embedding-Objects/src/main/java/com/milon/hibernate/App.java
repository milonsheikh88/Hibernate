package com.milon.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started...");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session= factory.openSession();
		
		//Create Certificate object
		Certificate certificate=new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration("2 Month");
		
		//Create Student object
		Student st=new Student();
		st.setId(101);
		st.setName("MILON");
		st.setCity("Dhaka");
		st.setCerti(certificate);
		
		Address ad=new Address();
		ad.setStreet("Street1");
		ad.setCity("Dhaka");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(15.3333);
		
		Transaction tx = session.beginTransaction();

		session.save(st);
		session.save(ad);
		
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Done...");
	}
}

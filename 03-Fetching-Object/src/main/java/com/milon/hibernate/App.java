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
		
		//get student 101
		Session session= factory.openSession();
		Student student=(Student) session.load(Student.class, 101);
		
		Address ad=(Address) session.get(Address.class, 1);
		
		System.out.println(student);
		System.out.println(ad);
		
		session.close();
		factory.close();
		System.out.println("Done...");
	}
}

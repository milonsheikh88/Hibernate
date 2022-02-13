package com.milon.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session= factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Employee e1=new Employee();
		Employee e2=new Employee();
		
		Project p1=new Project();
		Project p2=new Project();
		
		e1.setEid(33);
		e1.setName("MILON");
		
		e2.setEid(34);
		e2.setName("MAMUN");
		
		p1.setPid(22);
		p1.setProjectName("Library management system");

		p2.setPid(23);
		p2.setProjectName("Ecommarce management system");
		
		List <Employee> eList= new ArrayList<Employee>();
		eList.add(e1);
		eList.add(e2);
		
		List <Project> pList=new ArrayList<Project>();
		pList.add(p1);
		pList.add(p2);
		
		p1.setEmps(eList);
		e1.setProjects(pList);
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);

		tx.commit();
		
		// Fetching......
//		Project question=(Project) session.get(Project.class, 1212);
//		
//		System.out.println(question.getQuestion());
//		System.out.println(question.getAnswer().getAnswer());
		
		session.close();
		factory.close();
		System.out.println("Done...");
	}
}

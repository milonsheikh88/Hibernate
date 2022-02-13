package com.milon.hibernate;

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

		//Create Question Object
		Question q1=new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is java?");
		
		//Create Answer Object
		Answer a1=new Answer();
		a1.setAnswerId(343);
		a1.setAnswer("Java is a programming language.");
		a1.setQuestion(q1);
		q1.setAnswer(a1);
		
		//Create Question Object
		Question q2=new Question();
		q2.setQuestionId(1213);
		q2.setQuestion("What is collection framwork");
		
		//Create Answer Object
		Answer a2=new Answer();
		a2.setAnswerId(344);
		a2.setAnswer("API to work with group of object.");
		a2.setQuestion(q2);
		q2.setAnswer(a2);

		session.save(q1);
		session.save(q2);
		
		session.save(a1);
		session.save(a2);

		tx.commit();
		
		// Fetching......
		Question question=(Question) session.get(Question.class, 1212);
		
		System.out.println(question.getQuestion());
		System.out.println(question.getAnswer().getAnswer());
		
		session.close();
		factory.close();
		System.out.println("Done...");
	}
}

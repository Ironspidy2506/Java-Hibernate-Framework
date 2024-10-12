package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();

        // Creating a question
        Question q1 = new Question();
        q1.setQuestion_id(1212);
        q1.setQuestion("What is Java");

        Answer a1 = new Answer();
        a1.setAnswer_id(313);
        a1.setAnswer("Java is Programming Language");
        a1.setQuestions(q1);
        

        Answer a2 = new Answer();
        a2.setAnswer_id(344);
        a2.setAnswer("It can create software");
        a2.setQuestions(q1);
    

        Answer a3 = new Answer();
        a3.setAnswer_id(34);
        a3.setAnswer("Java has various frameworks");
        a3.setQuestions(q1);

        List<Answer> list  = new ArrayList<Answer>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        q1.setAnswers(list);


        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        // session.save(q1);
        // session.save(a1);
        // session.save(a2);
        // session.save(a3);

        Question q = (Question) session.get(Question.class, 1212);
        System.out.println(q.getQuestion_id());
        System.out.println(q.getQuestion());
        tx.commit();

        session.close();
        factory.close();
    }
}

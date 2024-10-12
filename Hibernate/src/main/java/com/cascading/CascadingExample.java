package com.cascading;


import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadingExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();

        Session s = factory.openSession();

        Question q = new Question();
        q.setQuestion_id(11);
        q.setQuestion("What is Java?");
        
        Answer a1 = new Answer(1, "Java is a Programming lang");
        Answer a2 = new Answer(1, "Java is a awesome");
        Answer a3= new Answer(1, "Java is a backend");

        List<Answer> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        q.setAnswers(list);

        Transaction tx = s.beginTransaction();

        s.save(q);
        

        tx.commit();

        s.close();
        factory.close();
    }
}

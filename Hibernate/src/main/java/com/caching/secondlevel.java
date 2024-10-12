package com.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.Student;


public class secondlevel {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        
        //First Session
        Session session1 = factory.openSession();
        Student student1 = session1.get(Student.class, 12424);
        System.out.println(student1);
        session1.close();

        // Second Session
        Session session2 = factory.openSession();
        Student student2 = session2.get(Student.class, 12424);
        System.out.println(student2);
        session2.close();

        factory.close();
    }
}

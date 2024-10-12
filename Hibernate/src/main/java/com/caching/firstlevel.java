package com.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.Student;

public class firstlevel {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();

        Session s = factory.openSession();

        //By default enabled
        Student student = (Student) s.get(Student.class, 12424);

        System.out.println(student); 
        System.out.println("Working on laptop");

        Student student1 = (Student) s.get(Student.class, 12424);
        System.out.println(student1);

        s.close();
        factory.close();
    }
}

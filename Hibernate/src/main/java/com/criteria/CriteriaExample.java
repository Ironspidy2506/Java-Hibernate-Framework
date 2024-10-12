package com.criteria;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class CriteriaExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        
        Session session = factory.openSession();

        Criteria c = session.createCriteria(Student.class);
        
        // c.add(Restrictions.eq("certi.course", "Java"));
        c.add(Restrictions.like("certi.course", "Java%"));
        c.add(Restrictions.gt("id", 24));

        List<Student> list = c.list();

        for(Student s : list) {
            System.out.println(s);
        }
        
        session.close();
        factory.close();
    }
}

package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        
        Session session = factory.openSession();

        Person p1 = new Person(12, "Priyanshu", "Ahmedabad", "9724055969");
        Transaction tx = session.beginTransaction();
        session.save(p1);
        tx.commit();

        
        session.close();
        factory.close();
    }
}

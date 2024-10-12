package com.example;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Project Start!");
        // Configuration cfg = new Configuration();
        // cfg.configure();

        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        
        // Creating Object of Student Class
        Student st = new Student();
        st.setid(101);
        st.setName("Priyanshu");
        st.setCity("Ahmedabad");

        // Creating Object of Address Class
        Address ad = new Address();
        ad.setStreet("Street 1");
        ad.setCity("Ahmd");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.1234);

        // System.out.println(st);

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        session.save(st);
        session.save(ad);

        tx.commit();

        session.close();

        // System.out.println(factory);

        // System.out.println(factory.isClosed());
    }
}

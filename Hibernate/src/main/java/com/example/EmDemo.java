package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();

        Student st = new Student();
        st.setid(102);
        st.setName("Aarushi");
        st.setCity("Raipur");

        Certificate cert = new Certificate();
        cert.setCourse("MBBS");
        cert.setDuration("5 years");

        st.setCerti(cert);

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        session.save(st);

        tx.commit();

        session.close();
        factory.close();
    }
}

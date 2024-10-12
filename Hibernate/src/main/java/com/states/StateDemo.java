package com.states;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Certificate;
import com.example.Student;

public class StateDemo {
    public static void main(String[] args) {
        //Hibernate States
        //Transient
        //Persistent
        //Detached
        //Removed

        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        Student st = new Student();
        st.setid(1414);
        st.setName("New Name");
        st.setCity("New City");
        st.setCerti(new Certificate("Java Hibernate", "2 Months"));

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.save(st);
         
        tx.commit();

        s.close();
        factory.close();
    }
}

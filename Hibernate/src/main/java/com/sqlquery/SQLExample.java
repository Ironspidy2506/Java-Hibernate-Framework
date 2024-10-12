package com.sqlquery;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.example.Student;

public class SQLExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();

        Session s = factory.openSession();

        // This is SQL Query not HQL Query
        String q = "select * from student";;
        NativeQuery nq = s.createSQLQuery(q);
        List<Object[]> list = nq.list();

        for(Object[] st : list) {
            System.out.println(Arrays.toString(st));
            System.out.println(st[4] + ":" + st[3]);
        }

        factory.close();
    }
}

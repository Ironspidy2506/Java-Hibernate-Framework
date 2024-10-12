package com.pagination;

import org.hibernate.query.*;

import com.example.Student;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLPagination {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        Session s =  factory.openSession();


        Query q = s.createQuery("from Student");
        
        //Implementing Pagination using hibernate
        q.setFirstResult(0);
        q.setMaxResults(5);

        List<Student> list = q.list();
        for(Student st : list) {
            System.out.println(st.getid() + ":" + st.getName() + ":" + st.getCity());
        }
        
        s.close();
        factory.close();
    }
}

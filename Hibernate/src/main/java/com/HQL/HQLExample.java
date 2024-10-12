package com.HQL;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HQLExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();

        String query = "from Student where city=:x";

        Session s = factory.openSession();

        Query q = s.createQuery(query);

        // q.setParameter("x", "Lucknow");

        // // Single - Unique
        // q.uniqueResult();

        // // Multiple - List
        // List<Student> list = q.list();
        // for (Student stud : list) {
        // System.out.println(stud.getName());
        // }

        Transaction tx = s.beginTransaction();
        // // Delete Query
        // Query q2 = s.createQuery("delete from Student where city =:c");
        // q2.setParameter("c", "Raipur");

        // int r = q2.executeUpdate();
        // System.out.println(r + " rows updated");

        // // Update Query
        // Query q3 = s.createQuery("update Student set city =:c where name =:n");
        // q2.setParameter("n", "Aarushi");

        // int res = q3.executeUpdate();
        // System.out.println(res + " rows updated");

        // // Join query
        // Query q4 = s.createQuery("select q.question, q.question_id, a.answer from Question as q INNER JOIN q.answers as a");
        // List<Object[]> list2 = q4.getResultList();
        // for(Object[] arr : list2) {
        //     System.out.println(Arrays.toString(arr));
        // }

        tx.commit();

        s.close();
        factory.close();
    }
}

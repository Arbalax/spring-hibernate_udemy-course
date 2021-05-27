package com.arbalax.hibernate.demo;

import com.arbalax.hibernate.demo.entity.Course;
import com.arbalax.hibernate.demo.entity.Instructor;
import com.arbalax.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session

        Session session = factory.getCurrentSession();

        try {


            //start a transaction
            session.beginTransaction();

            // get the instructor from db

            int theId = 1;
            Instructor instructor = session.get(Instructor.class, theId);

            System.out.println("arbalax: Instructor: "+instructor);

            System.out.println("arbalax: Courses: "+instructor.getCourses());


            // commit transaction
            session.getTransaction().commit();

            session.close();

            System.out.println("\narbalax: The session is now closed!\n");

            System.out.println("arbalax: Courses: "+instructor.getCourses());

            System.out.println("arbalax: Done!");
        }
        finally {

            session.close();

            factory.close();
        }

    }
}

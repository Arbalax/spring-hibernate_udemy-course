package com.arbalax.hibernate.demo;

import com.arbalax.hibernate.demo.entity.Course;
import com.arbalax.hibernate.demo.entity.Instructor;
import com.arbalax.hibernate.demo.entity.InstructorDetail;
import com.arbalax.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesAndReviewsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session

        Session session = factory.getCurrentSession();

        try {


            //start a transaction
            session.beginTransaction();

            // get the course
            int theId = 10;
            Course course = session.get(Course.class, theId);


            // print the course
            System.out.println("Deleting the course ...");
            System.out.println(course);

            // print the course reviews
            System.out.println(course.getReviews());

            // delete the course
            session.delete(course);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            session.close();

            factory.close();
        }

    }
}

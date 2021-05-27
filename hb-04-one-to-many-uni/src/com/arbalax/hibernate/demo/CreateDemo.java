package com.arbalax.hibernate.demo;

import com.arbalax.hibernate.demo.entity.Instructor;
import com.arbalax.hibernate.demo.entity.InstructorDetail;
import com.arbalax.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;

public class CreateDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session

        Session session = factory.getCurrentSession();

        try {

            // create the objects

//            Instructor tempInstructor =
//                    new Instructor("Chad", "Darby", "darby@gmail.com");
//
//            InstructorDetail tempInstructorDetail =
//                    new InstructorDetail("http://www.youtube.com/darby",
//                            "codding");

            Instructor tempInstructor =
                    new Instructor("Madhu", "Patel", "madhu@gmail.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.youtube.com/madhu",
                            "guitar");

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //start a transaction
            session.beginTransaction();

            // save the instructor
            // this will ALSO save the details object because of CascadeType.ALL
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }
}

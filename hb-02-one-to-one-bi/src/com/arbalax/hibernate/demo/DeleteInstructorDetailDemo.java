package com.arbalax.hibernate.demo;

import com.arbalax.hibernate.demo.entity.Instructor;
import com.arbalax.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

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

            //start a transaction
            session.beginTransaction();

            // get the instructor detail object
            int theId = 3;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

            // print the instructor detail
            System.out.println("instructorDetail: "+instructorDetail);

            // print the associateed instructor
            System.out.println("the associated instructor: "+instructorDetail.getInstructor());

            // delete the instruction detail

            System.out.println("Deleting instructorDetail " + instructorDetail);
            session.delete(instructorDetail);

            // remove the associated object reference
            // break bi-directional link

            instructorDetail.getInstructor().setInstructorDetail(null);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }

    }
}

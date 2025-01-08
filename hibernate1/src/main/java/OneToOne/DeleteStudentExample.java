package OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentExample {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        // Get session
        Session session = factory.getCurrentSession();

        try {
            // Start a new session and transaction
            session.beginTransaction();

            // Retrieve a student by id
            int studentId = 101; // For example, student with ID 101
            Student student = session.get(Student.class, studentId);

            // Delete the student (this will also delete the associated laptop due to cascade)
            if (student != null) {
                System.out.println("Deleting student: " + student);
                session.delete(student); // The associated laptop will also be deleted
            }

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Student and Laptop deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up
            session.close();
            factory.close();
        }
    }
}


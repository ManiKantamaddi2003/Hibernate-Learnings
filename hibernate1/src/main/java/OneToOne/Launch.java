package OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Launch {

	public static void main(String[] args) {
		// Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        // Get session
        Session session = factory.getCurrentSession();

        try {
            // Create objects
            Laptop laptop = new Laptop(1, "Mortola", "zPS 33");
            Student student = new Student(101, "Deccan", laptop);
            System.out.println(laptop);
            System.out.println(student);

            // Start transaction
            Transaction transaction = session.beginTransaction();

            // Save the student object (this will also save the associated laptop)
            session.save(student);

            // Commit transaction
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the factory to release resources
            factory.close();
        }
	}

}

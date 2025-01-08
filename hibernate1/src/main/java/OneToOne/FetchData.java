package OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchData {
	
	public static void main(String[] args) {
		// Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        // Get session
        Session session = factory.getCurrentSession();

        try {
          
          
            // Start transaction
            Transaction transaction = session.beginTransaction();
            
            Student s=session.get(Student.class,101);
            Laptop l=s.getLaptop();
            System.out.println(s);
            System.out.println(l);

         

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

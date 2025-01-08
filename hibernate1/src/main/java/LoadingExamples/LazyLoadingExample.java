package LoadingExamples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LazyLoadingExample {
	public static void main(String[] args) {
        // Setup Hibernate session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        // Start a transaction
        session.beginTransaction();
        
        // Fetch the department with ID 1 (Lazy Loading)
        Department department = session.get(Department.class, 1);
        
        // The employees are not loaded yet
        System.out.println("Department: " + department.getName());
        
        // Access employees (Lazy Initialization occurs here)
        System.out.println("Employees:");
        for (Employee employee : department.getEmployees()) {
            System.out.println(employee.getName());
        }
        
        // Commit transaction
        session.getTransaction().commit();
        
        // Close the session
        session.close();
    }

}
//In this example, the employees list is not fetched immediately when the Department is loaded. 
//However, once we access the getEmployees() method, Hibernate performs another query to fetch the employees for that department.
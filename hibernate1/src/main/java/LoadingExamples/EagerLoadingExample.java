package LoadingExamples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLoadingExample {

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
        
        // Fetch the department with ID 1 and its employees (Eager Loading)
        Department department = session.get(Department.class, 1);
        
        // The employees are loaded eagerly and can be accessed immediately
        System.out.println("Department: " + department.getName());
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

//In this example, when we load the Department with ID 1, 
//the employees list is fetched immediately, as specified by fetch = FetchType.EAGER. 
//All employees associated with that department are loaded in the same query.

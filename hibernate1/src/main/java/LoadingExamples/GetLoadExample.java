package LoadingExamples;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//The get() method will always hit the database immediately and return the entity.
//The load() method returns a proxy object initially, and the database will be hit only when any method (like getName()) is called on the Department object. 
//If the Department with the provided id is not found, load() will throw an exception, while get() will return null.

public class GetLoadExample {

    public static void main(String[] args) {
        // Setup Hibernate session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        // Start a transaction
        Transaction transaction = session.beginTransaction();

        // Using get() method to fetch a department by id
        System.out.println("\nUsing get() method:");
        int departmentId = 11; // Assume we have a department with id=1
        Department department = session.get(Department.class, departmentId);
        if (department != null) {
            System.out.println("Department Name: " + department.getName());
            // Print employees associated with the department
            for (Employee employee : department.getEmployees()) {
                System.out.println("Employee Name: " + employee.getName());
            }
        } else {
            System.out.println("Department not found.");
        }

        // Using load() method to fetch a department by id
        System.out.println("\nUsing load() method:");
        department = session.load(Department.class, departmentId);
        if (department != null) {
            System.out.println("Department Name: " + department.getName());
            // Print employees associated with the department
            for (Employee employee : department.getEmployees()) {
                System.out.println("Employee Name: " + employee.getName());
            }
        }

        // Commit the transaction
        transaction.commit();

        // Close the session and factory
        session.close();
        factory.close();
    }
}

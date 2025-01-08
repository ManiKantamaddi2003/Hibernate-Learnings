package ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Main {
    
    public static void main(String[] args) {
        
        // Setup Hibernate session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Create new category objects
            Category category1 = new Category();
            category1.setName("Electronics");

            Category category2 = new Category();
            category2.setName("Home Appliances");

            // Create new product objects
            Product product1 = new Product();
            product1.setName("Laptop");
            product1.setPrice(1000.00);

            Product product2 = new Product();
            product2.setName("Washing Machine");
            product2.setPrice(500.00);

            // Establish many-to-many relationship
            Set<Category> categories1 = new HashSet<>();
            categories1.add(category1);
            categories1.add(category2);
            product1.setCategories(categories1);

            Set<Category> categories2 = new HashSet<>();
            categories2.add(category2);
            product2.setCategories(categories2);

            // Save the products and categories
            session.beginTransaction();

            // Save categories first (due to cascade type)
            session.save(category1);
            session.save(category2);

            // Save products
            session.save(product1);
            session.save(product2);

            session.getTransaction().commit();
            System.out.println("Transaction committed. Data saved successfully.");
        } finally {
            factory.close();
        }
    }
}

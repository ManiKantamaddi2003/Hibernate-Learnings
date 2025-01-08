package ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddProducts {

    public static void main(String[] args) {
        // Setup Hibernate session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        
        // Start a transaction
        Transaction transaction = session.beginTransaction();
        
        try {
            // Create a new Category
            Category category = new Category();
            category.setName("Electrical");

            // Save the category (make sure it's persisted)
            session.save(category); // Save the category first

            // Create a new Product
            Product product = new Product();
            product.setName("TV");
            product.setPrice(7890);

            // Add the Category to the Product
            product.addCategory(category); // Add category to product's set of categories

            // Save the Product (this will also save the relationship in the join table)
            session.save(product);
            
            System.out.println("Product and Category Added");

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }
}


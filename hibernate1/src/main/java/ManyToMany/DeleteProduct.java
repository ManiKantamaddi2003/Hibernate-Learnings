package ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteProduct {
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
        
//        Product product=session.get(Product.class, 5);
//        session.delete(product);
        
        Category category=session.get(Category.class,3);
        session.delete(category);
        transaction.commit();
        System.out.println("Category Deleted");
	}

}

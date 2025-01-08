package ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateProduct {

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
        
        Product product=session.get(Product.class, 2);
        product.setName("Grinder");
        product.setPrice(9087);
        System.out.println("Product Updated");
        session.saveOrUpdate(product);
        transaction.commit();
	}

}

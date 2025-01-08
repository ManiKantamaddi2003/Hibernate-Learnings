package ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateCategory {

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
        
        Category category=session.get(Category.class,3);
        category.setName("Electronical Appliences");
        session.update(category);
        System.out.println("Category Updated");
        transaction.commit();
        
	}

}

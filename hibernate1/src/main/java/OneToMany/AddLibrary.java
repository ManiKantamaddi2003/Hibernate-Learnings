package OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddLibrary {

	public static void main(String[] args) {
		Configuration config=new Configuration();
		config.configure();
		config.addAnnotatedClass(Library.class);
		config.addAnnotatedClass(Book.class);
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Library l2=new Library();
		l2.setName("National Library");
		session.save(l2);
		System.out.println("Library Added");
		transaction.commit();
	}

}

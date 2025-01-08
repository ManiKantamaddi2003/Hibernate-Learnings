package OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddMoreBooks {

	public static void main(String[] args) {
		Configuration config=new Configuration();
		config.configure();
		config.addAnnotatedClass(Library.class);
		config.addAnnotatedClass(Book.class);
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		Library library=session.get(Library.class,2);
		Book b3=new Book();
		b3.setTitle("The Reason Of Story");
		b3.setLibrary(library);
		
		Book b4=new Book();
		b4.setTitle("The Answer");
		b4.setLibrary(library);
		
		library.getBooks().add(b3);
		library.getBooks().add(b4);
		
		session.saveOrUpdate(library);
		t.commit();

	}

}

package OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		Configuration config=new Configuration();
		config.configure();
		config.addAnnotatedClass(Library.class);
		config.addAnnotatedClass(Book.class);
		SessionFactory sesssionFactory=config.buildSessionFactory();
		Session session=sesssionFactory.openSession();
		Transaction t=session.beginTransaction();
		Library library=new Library();
		library.setName("Central Library");
		Book b1=new Book();
		b1.setLibrary(library);
		b1.setTitle("The Doshna");
		Book b2=new Book();
		b2.setLibrary(library);
		b2.setTitle("The Secret");
		// Add Books To Library
		List<Book>books=new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		library.setBooks(books);
		
		session.save(library);
		
		
		t.commit();
		System.out.println("Data saved successfully!");
		session.close();
		sesssionFactory.close();
	}

}

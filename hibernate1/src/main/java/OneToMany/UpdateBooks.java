package OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateBooks {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Configuration config=new Configuration();
		config.configure();
		config.addAnnotatedClass(Library.class);
		config.addAnnotatedClass(Book.class);
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Library lib=session.get(Library.class,1);
		
		Book book=session.get(Book.class,1);
		book.setTitle("The Journey");
		session.update(book);
		
		System.out.println("Book Updated SucessFully");
		
		transaction.commit();
		
	}

}

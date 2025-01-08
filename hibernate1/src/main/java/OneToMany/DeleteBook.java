package OneToMany;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteBook {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Configuration config=new Configuration();
		config.configure();
		config.addAnnotatedClass(Library.class);
		config.addAnnotatedClass(Book.class);
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Book book=session.get(Book.class,6);
		session.delete(book);
		System.out.println("Book Deleted SucessFully");
		session.saveOrUpdate(book);
		
		transaction.commit();
	}

}

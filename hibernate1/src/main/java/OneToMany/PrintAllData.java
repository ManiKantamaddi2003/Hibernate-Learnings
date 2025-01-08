package OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PrintAllData {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Configuration config=new Configuration();
		config.configure();
		config.addAnnotatedClass(Library.class);
		config.addAnnotatedClass(Book.class);
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		System.out.println("Enter Libray Id");
		int id=scanner.nextInt();
		Library lib=session.get(Library.class,id);
		System.out.println(lib.getName());
		List<Book>books=new ArrayList<Book>();
		books=lib.getBooks();
		for(Book e:books)
		{
			System.out.println(e.getId()+" "+e.getTitle());
		}
		
	}

}

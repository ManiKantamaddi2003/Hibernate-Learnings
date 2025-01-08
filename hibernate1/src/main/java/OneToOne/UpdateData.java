package OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {
	public static void main(String args[])
	{
		Configuration config=new Configuration();
		config.configure();
		config.addAnnotatedClass(Student.class);
		config.addAnnotatedClass(Laptop.class);
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		Transaction t=session.beginTransaction();
		Laptop l=session.get(Laptop.class, 1);
		l.setModel("Qdr234");
		session.update(l);
		
		t.commit();
	}

}

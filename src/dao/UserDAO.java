package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.User;
import utility.HibernateConnectionManager;

public class UserDAO implements UserDaoInterface {

	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();
	//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@Override
	public int signUp(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if (session.save(user) != null) {
			transaction.commit();
			session.close();
			return 1;
		} else
			return 0;
	}

	@Override
	public boolean loginUser(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.getTransaction();
			transaction.begin();
			Query query = session.createQuery(
					"from USER_LOGIN where email='" + user.getEmail() + "' password='" + user.getPassword() + "'");

			user = (User) query.uniqueResult();

			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				session.close();
			}
			e.printStackTrace();
		}
		return false;
	}

}

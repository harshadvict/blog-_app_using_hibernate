package utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnectionManager {

	private static SessionFactory sf = null;

	public static SessionFactory getSessionFactory() {
		if (sf == null) {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			sf = config.buildSessionFactory();
		}
		return sf;

	}
}

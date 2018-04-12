package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateMongoSessionUtils {
	private static EntityManagerFactory entityManagerFactory = null;
	 
	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("myPersistence");
		} catch (Exception e) {
			System.err.println("Initial EntityManagerFactory creation failed." + e);
		}
	}
 
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
 
	public static void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}
}

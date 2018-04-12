/*---------------------------------------------Sang----------------------------------------------------------------*/
package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import model.Loging;
import util.HibernateMongoSessionUtils;

@SuppressWarnings("unchecked")
public class LogingDaoImpl implements LogingDao {
	private EntityManagerFactory entityManagerFactory;
	@Autowired(required = true)
	private MongoTemplate mongoTemplate;

	@Override
	public Loging getLoging(Integer idLogin) {
		entityManagerFactory = HibernateMongoSessionUtils.getEntityManagerFactory();
		EntityManager em = entityManagerFactory.createEntityManager();
		Loging loging = new Loging();
		DBObject query = new BasicDBObject();
		query.put("user_id", idLogin);
		DBObject cursor = mongoTemplate.getDb().getCollection("USER").findOne(query);
		loging.setUserId(Integer.parseInt((cursor.get("user_id").toString())));
		loging.setUsername(cursor.get("user_name").toString());
		loging.setPassword(cursor.get("pass_word").toString());
		em.getTransaction().begin();
		em.persist(loging);
		em.getTransaction().commit();
		em.close();
		HibernateMongoSessionUtils.closeEntityManagerFactory();
		return loging;
	}

	@Override
	public List<Loging> listLoging() {
		entityManagerFactory = HibernateMongoSessionUtils.getEntityManagerFactory();
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Loging> logingList = mongoTemplate.findAll(Loging.class);
		em.getTransaction().begin();
		em.persist(logingList);
		em.getTransaction().commit();
		em.close();
		HibernateMongoSessionUtils.closeEntityManagerFactory();
		return logingList;
	}

	@Override
	public Loging checkLoging(String username, String password) {
		entityManagerFactory = HibernateMongoSessionUtils.getEntityManagerFactory();
		EntityManager em = entityManagerFactory.createEntityManager();
		Loging loging = new Loging();
		DBObject query = new BasicDBObject();
		query.put("user_name", username);
		query.put("pass_word", password);
		DBObject cursor = mongoTemplate.getDb().getCollection("USER").findOne(query);
		loging.setUserId(Integer.parseInt((cursor.get("user_id").toString())));
		loging.setUsername(cursor.get("user_name").toString());
		loging.setPassword(cursor.get("pass_word").toString());
		em.getTransaction().begin();
		em.persist(loging);
		em.getTransaction().commit();
		em.close();
		HibernateMongoSessionUtils.closeEntityManagerFactory();
		
		if (loging.getUsername().equals("")) {
			return null;
		}
		return loging;
	}
}

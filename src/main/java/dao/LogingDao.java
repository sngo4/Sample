/*---------------------------------------------Sang----------------------------------------------------------------*/
package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import model.Loging;

@Repository
public interface LogingDao {
	
	public SessionFactory getSessionFactory();
	
	public void setSessionFactory(SessionFactory sessionFactory);
	
	public Loging getLoging(Integer logingID);
	
	public List<Loging> listLoging();
	
	public Loging checkLoging(String username, String password);


}

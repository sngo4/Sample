/*---------------------------------------------Sang----------------------------------------------------------------*/
package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

//import model.Account;
import model.Loging;

@SuppressWarnings("unchecked")
public class LogingDaoImpl implements LogingDao{
	
	private SessionFactory sessionFactory;

	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Loging getLoging(Integer idLogin){
		Session session = getSessionFactory().openSession();
		Loging loging = (Loging) session.get(Loging.class, idLogin);
		session.close();
		return loging;
	}
	@Override
	public List<Loging> listLoging(){
		Session session = getSessionFactory().openSession();
 
		List<Loging> list = session.createQuery("from USER").list();
        session.close();
        return list;
	}
	@Override
	public Loging checkLoging(String username, String password){
		Session session = getSessionFactory().openSession();
        List<Loging> list = session.createQuery("from USER").list();
        session.close();
        for (Loging person : list) {
        	if (person.getPassword().equals(password) && person.getUsername().equals(username)) {
				return person;
			}
			
		}
        return null;
	}
}

/*---------------------------------------------Sang----------------------------------------------------------------*/
package dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import model.Loging;

@Repository
public interface LogingDao {
	
	public Loging getLoging(Integer idLogin);
	
	public List<Loging> listLoging();
	
	public Loging checkLoging(String username, String password);


}

/*---------------------------------------------Sang----------------------------------------------------------------*/
package service;

import java.util.List;

import model.Loging;

public interface LogingService {
	
	
	public Loging getLoging(Integer idLogin);
	
	public List<Loging> findAllLoging();
	
	public Loging checkLoging(String username, String password);
	

}

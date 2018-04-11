/*---------------------------------------------Sang----------------------------------------------------------------*/
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import dao.LogingDao;
import model.Loging;

@Repository
public class LogingServiceImpl implements LogingService{
	@Autowired
	@Qualifier("logingDao")
	private LogingDao dao;
	
	@Override
	public Loging getLoging(Integer idLogin){
		return dao.getLoging(idLogin);
	}
	@Override
	public List<Loging> findAllLoging(){
		return dao.listLoging();
	}
	@Override
	public Loging checkLoging(String username, String password){
		return dao.checkLoging(username, password);
	}

}

package dao;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import model.Account;
import model.AccountType;
import model.State;
import util.Validate;

@SuppressWarnings("unchecked")
@Repository
public class AccountDaoImpl implements AccountDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(Account account) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(account);
		tx.commit();
		session.close();

	}

	@Override
	public List<Account> listAccount() {
		Session session = getSessionFactory().openSession();
		List<Account> list = session.createQuery("from Account").list();
		session.close();
		return list;
	}

	// ===============================================================================================================
	@Override
	public void deleteAccountById(long accountNumber) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Account account = (Account) session.get(Account.class, accountNumber);
		session.delete(account);
		tx.commit();
		session.close();

	}

	@Override
	public void updateAccount(Account account) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(account);
		tx.commit();
		session.close();

	}

	@Override
	public Account findByAccountNumber(long accountNumber) {
		
		Session session = getSessionFactory().openSession();
		Account account = (Account) session.get(Account.class, accountNumber);
		session.close();
		return account;
	}
	// ===============================================================================================================
	// ------------------------Nhut-------------------------

	@Override
	public List<Account> getByAccountNumber(String accountNumber) {
		if (Validate.checkNumberInput(accountNumber)) {
			Session session = getSessionFactory().openSession();
			String hql = "from Account where accountNumber= :accountNumberParam";
			Query query = session.createQuery(hql);
			query.setParameter("accountNumberParam", Long.parseLong(accountNumber));

			List<Account> listResult = query.list();
			session.close();
			return listResult;
		}
		return null;
	}

	@Override
	public List<Account> getByIDCard(String cardID) {
		// Account account = new Account();
		if (Validate.checkNumberInput(cardID)) {
		Session session = getSessionFactory().openSession();
		String hql = "from Account where cardID= :cardIdParam";
		Query query = session.createQuery(hql);
		query.setParameter("cardIdParam", Long.parseLong(cardID));

		List<Account> listResult = query.list();
		session.close();
		return listResult;
		}
		return null;
	}

	@Override
	public List<Account> getByAccountName(String accountName) {
		Session session = getSessionFactory().openSession();
		String hql = "from Account where firstName like :accountName or lastName like :accountName";
		Query query = session.createQuery(hql);
		query.setParameter("accountName", "%" + accountName + "%");
		List<Account> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<Account> getByAccountType(String accountType) {
		List<Account> listResult = null;

		if (accountType.equals("SAVING") || accountType.equals("OTHER") || accountType.equals("DEPOSIT")) {
			Session session = getSessionFactory().openSession();
			String hql = "from Account where accountType = :accountTypeparam";
			Query query = session.createQuery(hql);

			query.setParameter("accountTypeparam", AccountType.valueOf(accountType));
			listResult = query.list();
			session.close();
		}
		return listResult;
	}

	@Override
	public List<Account> getByAccountState(String accountState) {
		List<Account> listResult = null;

		if (accountState.equals("ACTIVE") || accountState.equals("NEW") || accountState.equals("DISABLE")
				|| accountState.equals("REMOVABLE")) {
			Session session = getSessionFactory().openSession();
			String hql = "from Account where state = :stateparam";
			Query query = session.createQuery(hql);

			query.setParameter("stateparam", State.valueOf(accountState));
			listResult = query.list();
			session.close();
		}
		return listResult;
	}

	@Override
	public List<Account> getByAccountPhone(String accountPhone) {
		Session session = getSessionFactory().openSession();
		String hql = "from Account where phoneNumber1 like :accountPhone or phoneNumber2 like :accountPhone";
		Query query = session.createQuery(hql);
		query.setParameter("accountPhone", "%" + accountPhone + "%");
		List<Account> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<Account> getByAccountArress(String accountArress) {
		Session session = getSessionFactory().openSession();
		String hql = "from Account where address1 like :accountArress or address2 like :accountArress";
		Query query = session.createQuery(hql);
		query.setParameter("accountArress", "%" + accountArress + "%");
		List<Account> list = query.list();
		session.close();
		return list;
	}

}

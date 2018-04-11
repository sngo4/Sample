package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import dao.AccountDao;
import model.Account;

public class AccountServiceImpl implements AccountService {
	@Autowired
	@Qualifier("accountDao")
	private AccountDao dao;

	@Override
	public void saveAccount(Account account) {
		dao.create(account);

	}

	@Override
	public void updateAccount(Account account) {
		dao.updateAccount(account);

	}

	@Override
	public void deleteAccountById(long accountNumber) {
		dao.deleteAccountById(accountNumber);

	}

	@Override
	public List<Account> findAllAccount() {
		return dao.listAccount();
	}
	// ------------------------------------Nhut--------------------------

	@Override
	public List<Account> findByIDCard(String cardId) {
		return dao.getByIDCard(cardId);
	}

	@Override
	public List<Account> findByAccountNumber(String accountNumber) {
		return dao.getByAccountNumber(accountNumber);
	}

	@Override
	public List<Account> findByAccountName(String accountName) {
		return dao.getByAccountName(accountName);
	}

	@Override
	public List<Account> findByAccountType(String type) {
		// TODO Auto-generated method stub
		return dao.getByAccountType(type);
	}

	@Override
	public List<Account> findByAccountState(String accountState) {
		return dao.getByAccountState(accountState);
	}

	@Override
	public List<Account> findByAccountPhone(String accountPhone) {
		// TODO Auto-generated method stub
		return dao.getByAccountPhone(accountPhone);
	}

	@Override
	public List<Account> findByAccountArress(String accountArress) {
		// TODO Auto-generated method stub
		return dao.getByAccountArress(accountArress);
	}

	@Override
	public Account findByAccountNumber(long accountNumber) {
		return dao.findByAccountNumber(accountNumber);
	}

}

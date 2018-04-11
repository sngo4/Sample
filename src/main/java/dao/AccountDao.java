package dao;

import java.util.List;

import model.Account;

public interface AccountDao {
	// ---------------------Tai------------------------
	public void create(Account account);

	public List<Account> listAccount();

	public void deleteAccountById(long number);

	public void updateAccount(Account account);
	

	Account findByAccountNumber(long accountNumber);

	// -------------------Nhut--------------------

	List<Account> getByAccountNumber(String accountNumber);

	List<Account> getByIDCard(String idCard);

	List<Account> getByAccountName(String accountName);

	List<Account> getByAccountType(String accountType);

	List<Account> getByAccountState(String accountState);

	List<Account> getByAccountPhone(String accountPhone);

	List<Account> getByAccountArress(String accountArress);

}

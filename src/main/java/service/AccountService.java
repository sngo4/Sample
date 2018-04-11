package service;

import java.util.List;

import model.Account;

public interface AccountService {

	Account findByAccountNumber(long accountNumber);

	void saveAccount(Account account);

	void updateAccount(Account account);

	void deleteAccountById(long accountNumber);

	List<Account> findAllAccount();

	// -----------------------------Nhut----------------------------
	List<Account> findByAccountNumber(String accountNumber);

	List<Account> findByIDCard(String cardId);

	List<Account> findByAccountName(String accountName);

	List<Account> findByAccountType(String type);

	List<Account> findByAccountState(String accountState);

	List<Account> findByAccountPhone(String accountPhone);

	List<Account> findByAccountArress(String accountArress);
}

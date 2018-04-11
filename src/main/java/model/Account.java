package model;

@SuppressWarnings("serial")
public class Account implements java.io.Serializable {
	private long accountNumber;

	private String firstName;

	private String midName;

	private String lastName;

	private String phoneNumber1;

	private String phoneNumber2;

	private String email1;

	private String email2;

	private String address1;

	private String address2;

	private State state; // kieu enum

	private AccountType accountType;

	private long cardID;

	public Account() {
	}

	public Account(long accountNumber, String firstName, String midName, String lastName, String phoneNumber1,
			String phoneNumber2, String email1, String email2, String address1, String address2, State state,
			AccountType accountType, long cardID) {

		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
		this.email1 = email1;
		this.email2 = email2;
		this.address1 = address1;
		this.address2 = address2;
		this.state = state;
		this.accountType = accountType;
		this.cardID = cardID;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public long getCardID() {
		return cardID;
	}

	public void setCardID(long cardID) {
		this.cardID = cardID;
	}

}

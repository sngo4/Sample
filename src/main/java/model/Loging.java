/*---------------------------------------------Sang----------------------------------------------------------------*/
package model;

@SuppressWarnings("serial")
public class Loging implements java.io.Serializable {
	private int userId;
	private String username;
	private String password;

	public Loging() {

	}

	public Loging(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Loging(int idLogin, String username, String password) {
		this.userId = idLogin;
		this.username = username;
		this.password = password;

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

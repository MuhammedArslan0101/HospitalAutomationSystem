package entity;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * @author Muhammed ARSLAN
 *
 */
public class Admin {

	private String username;
	private String password;
	private Integer idu;

	

	public Admin() {
		super();
	}



	public Admin( Integer idu ,String username, String password) {
		this.username = username;
		this.password = password;
		this.idu = idu;
	}



	public Integer getIdu() {
		return idu;
	}

	public void setIdu(Integer idu) {
		this.idu = idu;
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

	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + ", idu=" + idu + "]";
	}

}

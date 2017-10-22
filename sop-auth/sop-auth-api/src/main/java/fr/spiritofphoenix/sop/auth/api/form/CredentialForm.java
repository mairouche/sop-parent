package fr.spiritofphoenix.sop.auth.api.form;

import java.io.Serializable;

/**
 * Sign in User credentials
 * @author Meidi
 *
 */
public class CredentialForm implements Serializable {

	/**
	 * SUID
	 */
	private static final long serialVersionUID = 338813387821101229L;

	/**
	 * User given email
	 */
	private String email;
	
	/**
	 * User given password
	 */
	private String password;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}

package fr.spiritofphoenix.sop.auth.business.service;

import fr.spiritofphoenix.sop.auth.business.bo.UserBO;

/**
 * Authentication Business Service
 * @author Meidi
 *
 */
public interface AuthenticationService {

	/**
	 * User sign-in
	 * @param email
	 * @param password
	 * @return
	 */
	UserBO authenticate(String email, String password);
	
	/**
	 * User sign-out
	 * @param userId
	 * @return
	 */
	UserBO signOut(long userId);
	
	/**
	 * User password recovery
	 * @param email
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	boolean changePassword(String email, String oldPassword, String newPassword);
	
	/**
	 * Check if the user is authenticated
	 * @param userId
	 * @param token
	 * @return
	 */
	boolean isAuthenticated(long userId, String token);

	/**
	 * Send a mail for changing password if the email is found
	 * @param email
	 * @return
	 */
	boolean recoverPassword(String email);
}

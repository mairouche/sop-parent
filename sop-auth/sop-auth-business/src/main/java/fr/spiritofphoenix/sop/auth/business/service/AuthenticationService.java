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
	UserBO signIn(String email, String password);
	
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
	boolean recoverPassword(String email, String oldPassword, String newPassword);
	
	/**
	 * Check if the user is authenticated
	 * @param userId
	 * @param token
	 * @return
	 */
	boolean isAuthenticated(long userId, String token);
}

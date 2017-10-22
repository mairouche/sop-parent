package fr.spiritofphoenix.sop.auth.business.service;

import fr.spiritofphoenix.sop.auth.business.bo.UserBO;

/**
 * Registration Business Service
 * @author Meidi
 *
 */
public interface RegistrationService {

	/**
	 * Register a new User
	 * @param user
	 * @return
	 */
	UserBO registerUser(UserBO user);
}

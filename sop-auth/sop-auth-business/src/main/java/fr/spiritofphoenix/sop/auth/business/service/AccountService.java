package fr.spiritofphoenix.sop.auth.business.service;

import fr.spiritofphoenix.sop.auth.business.bo.UserBO;

/**
 * Account Business Service
 * @author Meidi
 *
 */
public interface AccountService {

	/**
	 * Get User's information
	 * @param userId
	 * @return
	 */
	UserBO getUserInformation(long userId);
	
	/**
	 * Modify User's information
	 * @param user
	 * @return
	 */
	UserBO modifyUserInformation(UserBO user);
}

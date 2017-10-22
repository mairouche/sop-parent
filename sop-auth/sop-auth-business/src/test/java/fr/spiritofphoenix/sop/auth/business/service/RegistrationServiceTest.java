package fr.spiritofphoenix.sop.auth.business.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.spiritofphoenix.sop.auth.business.bo.UserBO;
import fr.spiritofphoenix.sop.auth.business.util.AbstractBusinessTest;

public class RegistrationServiceTest extends AbstractBusinessTest {
	
	@Autowired
	private RegistrationService registrationService;

	@Test
	public void testRegisterNewUser() {
		UserBO user = new UserBO();
		user.setEmail("newUserEmail@sop.fr");
		user.setPassword("newUserPassword");
		user.setGroupId(1);
		assertTrue(registrationService.registerUser(user).getId() > 0);
	}

}

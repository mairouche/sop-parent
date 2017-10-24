package fr.spiritofphoenix.sop.auth.business.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.spiritofphoenix.sop.auth.business.bo.UserBO;
import fr.spiritofphoenix.sop.auth.business.util.AbstractBusinessTest;

public class AuthenticationServiceTest extends AbstractBusinessTest {
	
	@Autowired
	private AuthenticationService authenticationService;

	@Test
	public void testSignIn() {
		UserBO user = authenticationService.authenticate("testUserEmail@sop.fr", "testPassword");
		assertTrue(user != null && !user.getToken().equals("token1"));
	}
	
	@Test
	public void testSignOut() {
		assertTrue(authenticationService.signOut(1L).getToken().equals(""));
	}
	
	@Test
	public void testchangePassword() {
		assertTrue(authenticationService.changePassword("recoverPassUserEmail@sop.fr", "recoverPass", "newPass"));
	}
	
	@Test
	public void testIsAuthentified() {
		assertTrue(authenticationService.isAuthenticated(1L, "token1"));
	}
	
	@Test
	public void testRecoverPasswordSuccess() {
		assertTrue(authenticationService.recoverPassword("testUserEmail@sop.fr"));
	}
	
	@Test
	public void testRecoverPasswordFailure() {
		assertFalse(authenticationService.recoverPassword("testUser"));
	}

}

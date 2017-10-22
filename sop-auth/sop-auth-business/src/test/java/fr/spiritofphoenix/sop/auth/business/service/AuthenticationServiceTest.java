package fr.spiritofphoenix.sop.auth.business.service;

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
		UserBO user = authenticationService.signIn("testUserEmail@sop.fr", "testPassword");
		assertTrue(user != null && !user.getToken().equals("token1"));
	}
	
	@Test
	public void testSignOut() {
		assertTrue(authenticationService.signOut(1L).getToken().equals(""));
	}
	
	@Test
	public void testRecoverPassword() {
		assertTrue(authenticationService.recoverPassword("recoverPassUserEmail@sop.fr", "recoverPass", "newPass"));
	}
	
	@Test
	public void testIsAuthentified() {
		assertTrue(authenticationService.isAuthenticated(1L, "token1"));
	}

}

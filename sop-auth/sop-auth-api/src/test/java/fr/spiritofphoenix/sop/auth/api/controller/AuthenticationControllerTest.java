package fr.spiritofphoenix.sop.auth.api.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.spiritofphoenix.sop.auth.api.form.CredentialForm;
import fr.spiritofphoenix.sop.auth.api.util.AbstractControllerTest;

public class AuthenticationControllerTest extends AbstractControllerTest {
	
	private static final String AUTHENTICATION_ROUTE = "/auth/user/signin";
	private static final String SIGNOUT_ROUTE = "/auth/user/4/signout";
	private static final String RECOVER_PASSWORD_ROUTE = "/auth/user/recover";

	@Test
	public void testSignInUserSuccess() throws Exception {
		ObjectMapper jsonMapper = new ObjectMapper();
		CredentialForm credentials = new CredentialForm();
		credentials.setEmail("testUserEmail@sop.fr");
		credentials.setPassword("testPassword");
		this.request.setContent(jsonMapper.writeValueAsBytes(credentials));
        this.testJsonObjectRoute(AUTHENTICATION_ROUTE, HTTP_POST_METHOD);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void testSignInUserEmailFailure() throws Exception {
		ObjectMapper jsonMapper = new ObjectMapper();
		CredentialForm credentials = new CredentialForm();
		credentials.setEmail("testUser");
		credentials.setPassword("testPassword");
		this.request.setContent(jsonMapper.writeValueAsBytes(credentials));
		this.processRoute(AUTHENTICATION_ROUTE, HTTP_POST_METHOD);
        assertEquals(HttpStatus.FORBIDDEN.value(), response.getStatus());
	}
	
	@Test
	public void testSignInUserPasswordFailure() throws Exception {
		CredentialForm credentials = new CredentialForm();
		credentials.setEmail("testUserEmail@sop.fr");
		credentials.setPassword("test");
		this.request.setContent(jsonMapper.writeValueAsBytes(credentials));
		this.processRoute(AUTHENTICATION_ROUTE, HTTP_POST_METHOD);
        assertEquals(HttpStatus.FORBIDDEN.value(), response.getStatus());
	}
	
	@Test
	public void testSignOutUser() throws Exception {
		this.processRoute(SIGNOUT_ROUTE, HTTP_GET_METHOD);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void testRecoverPasswordSuccess() throws Exception {
		CredentialForm credentials = new CredentialForm();
		credentials.setEmail("testUserEmail@sop.fr");
		this.request.setContent(jsonMapper.writeValueAsBytes(credentials));
		this.processRoute(RECOVER_PASSWORD_ROUTE, HTTP_POST_METHOD);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void testRecoverPasswordFailure() throws Exception {
		CredentialForm credentials = new CredentialForm();
		credentials.setEmail("test");
		this.request.setContent(jsonMapper.writeValueAsBytes(credentials));
		this.processRoute(RECOVER_PASSWORD_ROUTE, HTTP_POST_METHOD);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
	}

}

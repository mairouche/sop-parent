package fr.spiritofphoenix.sop.auth.api.controller;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.spiritofphoenix.sop.auth.api.form.CredentialForm;
import fr.spiritofphoenix.sop.auth.api.vo.UserVO;
import fr.spiritofphoenix.sop.auth.business.bo.UserBO;
import fr.spiritofphoenix.sop.auth.business.service.AuthenticationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Authentication Controller
 * @author Meidi
 *
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private Mapper mapper;

	@Autowired
	private AuthenticationService authenticationService;

	/**
	 * Try to authenticate a user giving credentials
	 * @param credentials
	 * @return
	 */
	@PostMapping(value="/user/signin")
	@ApiOperation(value = "Sign in User", notes = "Signin a user by email/password generating a token")
	public ResponseEntity<?> authenticateUser(
			@ApiParam(value = "User's authentication information", required = true) 
			@RequestBody CredentialForm credentials) {
		UserBO user = authenticationService.authenticate(credentials.getEmail(), credentials.getPassword());
		if(user != null && authenticationService.isAuthenticated(user.getId(), user.getToken())) {
			return new ResponseEntity<UserVO>(mapper.map(user, UserVO.class), HttpStatus.OK);
		}
		return new ResponseEntity<String>("Authentication failure", HttpStatus.FORBIDDEN);
	}
	
	/**
	 * Sign out a user 
	 * @param credentials
	 * @return
	 */
	@GetMapping(value="/user/{userId}/signout")
	@ApiOperation(value = "Sign out User", notes = "Sign out a registred user")
	public ResponseEntity<String> signOutUser(
			@ApiParam(value = "User unique ID", required = true)
			@PathVariable long userId) {
		authenticationService.signOut(userId);
		return new ResponseEntity<String>("Logged out", HttpStatus.OK);
	}
	
	/**
	 * Launch password recovery
	 * @return
	 */
	@PostMapping(value="/user/recover")
	@ApiOperation(value = "Recover password", notes = "Recover user's lost password")
	public ResponseEntity<String> recoverPassword(
			@ApiParam(value = "User's credentials", required = true)
			@RequestBody CredentialForm credentials) {
		if(authenticationService.recoverPassword(credentials.getEmail())) {
			return new ResponseEntity<String>("Password recovery mail sent", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Email not found", HttpStatus.NOT_FOUND);
	}
}

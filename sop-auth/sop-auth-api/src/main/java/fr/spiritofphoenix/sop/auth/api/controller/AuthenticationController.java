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
	 * Try to authenticate a sign in user giving credentials
	 * @param credentials
	 * @return
	 */
	@PostMapping(value="/user/signin")
	public ResponseEntity<?> signInUser(@RequestBody CredentialForm credentials) {
		UserBO user = authenticationService.signIn(credentials.getEmail(), credentials.getPassword());
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
	public ResponseEntity<String> signOutUser(@PathVariable long userId) {
		authenticationService.signOut(userId);
		return new ResponseEntity<String>("Logged out", HttpStatus.OK);
	}
}

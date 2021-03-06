package fr.spiritofphoenix.sop.auth.business.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.spiritofphoenix.sop.auth.business.bo.UserBO;
import fr.spiritofphoenix.sop.auth.business.service.AuthenticationService;
import fr.spiritofphoenix.sop.auth.commons.util.TokenUtils;
import fr.spiritofphoenix.sop.auth.persistence.entity.User;
import fr.spiritofphoenix.sop.auth.persistence.repository.UserRepository;

/**
 * Authentication Business Service Implementation
 * @author Meidi
 *
 */
@Service("AuthenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private Mapper mapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenUtils tokenUtils;

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public UserBO authenticate(String email, String password) {
		User user = userRepository.findByEmail(email);
		if(isUserAuthenticable(password, user)) {
			user.setAccessToken(tokenUtils.createJWT(Long.toString(user.getId()), user.getEmail(), "auth", 1800000));
			userRepository.save(user);
			return mapper.map(user, UserBO.class);
		}
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public UserBO signOut(long userId) {
		User user = userRepository.findOne(userId);
		user.setAccessToken("");
		return mapper.map(userRepository.save(user), UserBO.class);
	}

	@Override
	public boolean changePassword(String email, String oldPassword, String newPassword) {
		User user = userRepository.findByEmail(email);
		if(isUserAuthenticable(oldPassword, user)) {
			user.setPassword(newPassword);
			return true;
		}
		return false;
	}

	@Override
	public boolean isAuthenticated(long userId, String token) {
		String userToken = userRepository.findOne(userId).getAccessToken();
		return userToken.equals(token) && !tokenUtils.jwtIsExpired(userRepository.findOne(userId).getAccessToken());
	}
	
	@Override
	public boolean recoverPassword(String email) {
		if(userRepository.findByEmail(email) != null) {
			// TODO : Send email
			return true;
		}
		return false;
	}
	
	/**
	 * Check if the User exists and gave the right password
	 * @param password
	 * @param user
	 * @return
	 */
	private boolean isUserAuthenticable(String password, User user) {
		return user != null && user.getPassword().equals(password) && user.isActive() && user.isLegals();
	}

}

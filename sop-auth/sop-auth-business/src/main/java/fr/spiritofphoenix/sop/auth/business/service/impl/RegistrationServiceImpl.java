package fr.spiritofphoenix.sop.auth.business.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.spiritofphoenix.sop.auth.business.bo.UserBO;
import fr.spiritofphoenix.sop.auth.business.service.RegistrationService;
import fr.spiritofphoenix.sop.auth.commons.util.TokenUtils;
import fr.spiritofphoenix.sop.auth.persistence.entity.User;
import fr.spiritofphoenix.sop.auth.persistence.repository.UserRepository;

/**
 * Registration Business Service implementation
 * @author Meidi
 *
 */
@Service("RegistrationService")
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private Mapper mapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenUtils tokenUtils;

	@Override
	public UserBO registerUser(UserBO user) {
		user.setAccessToken(tokenUtils.createJWT(Long.toString(user.getId()), user.getEmail(), "auth", 1800000));
		return mapper.map(userRepository.save(mapper.map(user, User.class)), UserBO.class);
	}

}

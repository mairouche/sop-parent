package fr.spiritofphoenix.sop.auth.business.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.spiritofphoenix.sop.auth.business.bo.UserBO;
import fr.spiritofphoenix.sop.auth.business.service.RegistrationService;
import fr.spiritofphoenix.sop.auth.business.util.TokenUtils;
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

	@Override
	public UserBO registerUser(UserBO user) {
		user.setToken(TokenUtils.generateToken());
		return mapper.map(userRepository.save(mapper.map(user, User.class)), UserBO.class);
	}

}

package fr.spiritofphoenix.sop.auth.business.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.spiritofphoenix.sop.auth.business.bo.UserBO;
import fr.spiritofphoenix.sop.auth.business.service.AccountService;
import fr.spiritofphoenix.sop.auth.persistence.entity.User;
import fr.spiritofphoenix.sop.auth.persistence.repository.UserRepository;

/**
 * Account Business Service Implementation
 * @author Meidi
 *
 */
@Service("AccountService")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private Mapper mapper;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public UserBO getUserInformation(long userId) {
		return mapper.map(userRepository.findOne(userId), UserBO.class);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public UserBO modifyUserInformation(UserBO user) {
		return mapper.map(userRepository.save(mapper.map(user, User.class)), UserBO.class);
	}

}

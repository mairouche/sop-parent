package fr.spiritofphoenix.sop.auth.persistence.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.spiritofphoenix.sop.auth.persistence.repository.UserRepository;
import fr.spiritofphoenix.sop.auth.persistence.util.AbstractRepositoryTest;

public class UserRepositoryTest extends AbstractRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void testFindUser() {
		assertNotNull(userRepository.findOne(1L));
	}

}

package fr.spiritofphoenix.sop.auth.persistence.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.spiritofphoenix.sop.auth.persistence.repository.GroupAuthorizationRepository;
import fr.spiritofphoenix.sop.auth.persistence.util.AbstractRepositoryTest;

public class GroupAuthorizationRepositoryTest extends AbstractRepositoryTest {
	
	@Autowired
	private GroupAuthorizationRepository groupAuthorizationRepository;

	@Test
	public void testFindGroupAuthorization() {
		assertNotNull(groupAuthorizationRepository.findOne(1L));
	}

}

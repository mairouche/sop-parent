package fr.spiritofphoenix.sop.auth.persistence.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.spiritofphoenix.sop.auth.persistence.repository.RoleRepository;
import fr.spiritofphoenix.sop.auth.persistence.util.AbstractRepositoryTest;

public class RoleRepositoryTest extends AbstractRepositoryTest {
	
	@Autowired
	private RoleRepository roleRepository;

	@Test
	public void testFindRole() {
		assertNotNull(roleRepository.findOne(1));
	}

}

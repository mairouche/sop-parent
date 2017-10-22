package fr.spiritofphoenix.sop.auth.persistence.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.spiritofphoenix.sop.auth.persistence.repository.GroupRepository;
import fr.spiritofphoenix.sop.auth.persistence.util.AbstractRepositoryTest;

public class GroupRepositoryTest extends AbstractRepositoryTest {
	
	@Autowired
	private GroupRepository groupRepository;

	@Test
	public void testFindGroup() {
		assertNotNull(groupRepository.findOne(1));
	}

}

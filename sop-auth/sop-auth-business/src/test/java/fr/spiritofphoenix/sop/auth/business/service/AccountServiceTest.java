package fr.spiritofphoenix.sop.auth.business.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.spiritofphoenix.sop.auth.business.bo.UserBO;
import fr.spiritofphoenix.sop.auth.business.util.AbstractBusinessTest;

public class AccountServiceTest extends AbstractBusinessTest {
	
	@Autowired
	private AccountService accountService;

	@Test
	public void testGetUserInformation() {
		assertNotNull(accountService.getUserInformation(1L));
	}
	
	@Test
	public void testModifyUserInformation() {
		UserBO user = new UserBO();
		user.setId(2L);
		user.setName("test");
		user.setSurname("testUpdateUserSurname");
		user.setPhone("0123456789");
		user.setEmail("test");
		user.setLegals(true);
		user.setActive(true);
		user.setGroupId(1);
		user.setPassword("testUpdate");
		user.setAccessToken("aaa");
		assertEquals(accountService.modifyUserInformation(user).getEmail(), "test");
	}

}

package fr.spiritofphoenix.sop.auth.commons.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.spiritofphoenix.sop.auth.commons.util.TokenUtils;

public class TokenUtilsTest extends AbstractCommonsTest {
	
	@Autowired
	private TokenUtils tokenUtils;

	@Test
	public void testCreateJwt() {
		assertNotNull(tokenUtils.createJWT("1", "user@sop.fr", "auth", 1800000));
	}

}

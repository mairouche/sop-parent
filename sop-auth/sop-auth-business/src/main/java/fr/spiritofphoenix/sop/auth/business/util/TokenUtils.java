package fr.spiritofphoenix.sop.auth.business.util;

import java.security.SecureRandom;

/**
 * Token utilitaries
 * @author Meidi
 *
 */
public class TokenUtils {

	/**
	 * Generate a user's token
	 * @return
	 */
	public static String generateToken() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		return bytes.toString();
	}
}

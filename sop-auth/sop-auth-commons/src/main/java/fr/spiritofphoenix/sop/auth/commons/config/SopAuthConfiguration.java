package fr.spiritofphoenix.sop.auth.commons.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Application global and environmental variables
 * @author Meidi
 *
 */
@Component
public class SopAuthConfiguration {

	/**
	 * API Secret Key
	 */
	@Value("#{appProps['apiSecretKey']}")
	private String apiSecretKey;

	/**
	 * @return the apiSecretKey
	 */
	public String getApiSecretKey() {
		return apiSecretKey;
	}
	
}

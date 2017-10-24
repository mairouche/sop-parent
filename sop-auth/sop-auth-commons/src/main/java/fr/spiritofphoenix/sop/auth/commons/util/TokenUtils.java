package fr.spiritofphoenix.sop.auth.commons.util;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.spiritofphoenix.sop.auth.commons.config.SopAuthConfiguration;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Token utilitaries
 * @author Meidi
 *
 */
@Component
public class TokenUtils {
	
	@Autowired
	private SopAuthConfiguration sopAuthConfiguration;

	/**
	 * Generate a JWT Token
	 * @param id
	 * @param issuer
	 * @param subject
	 * @param ttlMillis
	 * @return
	 */
	public String createJWT(String id, String issuer, String subject, long ttlMillis) {
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(sopAuthConfiguration.getApiSecretKey());
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	    JwtBuilder builder = Jwts.builder().setId(id)
	                                .setIssuedAt(now)
	                                .setSubject(subject)
	                                .setIssuer(issuer)
	                                .signWith(signatureAlgorithm, signingKey);
	    if (ttlMillis >= 0) {
	    long expMillis = nowMillis + ttlMillis;
	        Date exp = new Date(expMillis);
	        builder.setExpiration(exp);
	    }
	    return builder.compact();
	}
	
	/**
	 * Check JWT expiration time
	 * @param jwt
	 * @return
	 */
	public boolean jwtIsExpired(String jwt) {
		long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);
		return now.after(this.parseJWT(jwt).getExpiration());
	}
	
	/**
	 * Parse a JWT token created from the API
	 * @param jwt
	 */
	private Claims parseJWT(String jwt) {
	    return Jwts.parser()         
	       .setSigningKey(DatatypeConverter.parseBase64Binary(sopAuthConfiguration.getApiSecretKey()))
	       .parseClaimsJws(jwt).getBody();
	}
}

package com.kh.spring11.token;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test02토큰해석2 {
	
	@Autowired
	private JwtDecoder jwtDecoder;
	
	@Test
	public void test() {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0dXNlcjEiLCJhY2NvdW50SWQiOiJ0ZXN0dXNlcjEiLCJpc3MiOiJodHRwczovL3d3dy5raC1hY2FkZW15LmNvLmtyLyIsImFjY291bnROaWNrbmFtZSI6Iu2FjOyKpO2KuOycoOyggDEiLCJleHAiOjE3ODQ1MzM4MzAsImFjY291bnRMZXZlbCI6Iuu4jOuhoOymiCIsImlhdCI6MTc4NDUzMzc3MH0.EoLcVYjannrqN0suOfa47dE4BMZdbQ2y9rEzRBp-q5U";
		
		Jwt jwt = jwtDecoder.decode(token);
		
		log.debug("iss : {}", jwt.getIssuer());
		log.debug("iat : {}", jwt.getIssuedAt());
		log.debug("exp : {}", jwt.getExpiresAt());
		log.debug("sub : {}", jwt.getSubject());
		
		log.debug("accountId = {}", jwt.getClaimAsString("accountId"));
		log.debug("accountNickname = {}", jwt.getClaimAsString("accountNickname"));
		log.debug("accountLevel = {}", jwt.getClaimAsString("accountLevel"));
	}

}

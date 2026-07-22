package com.kh.spring11.token;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test02토큰해석 {
	
	@Test
	public void test() {
		//목표: 이미 만들어진 JWT Token의 정보를 불러와 검증 후 해석 결과 출력
		//[1] 만들어진 토큰을 하나 가져온다
		//[2] 토큰을 해석할 수 있는 도구를 생성한다
		//[3] 토큰 해석 및 결과를 확인한다. 
		
		//[1] 테스트1번에서 생성한 토큰을 복사해서 넣으면 된다
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0dXNlcjEiLCJhY2NvdW50SWQiOiJ0ZXN0dXNlcjEiLCJpc3MiOiJodHRwczovL3d3dy5raC1hY2FkZW15LmNvLmtyLyIsImFjY291bnROaWNrbmFtZSI6Iu2FjOyKpO2KuOycoOyggDEiLCJleHAiOjE3ODQ1MzM4MzAsImFjY291bnRMZXZlbCI6Iuu4jOuhoOymiCIsImlhdCI6MTc4NDUzMzc3MH0.EoLcVYjannrqN0suOfa47dE4BMZdbQ2y9rEzRBp-q5U";
		
		//[2]
		//- 해석에 사용할 Secret Key를 생성
		String secret = "12345678901234567890123456789012";
		SecretKey key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
		
		//-Secret Key = 를 이용해서 해석도구(JwtDecoder)생성
		JwtDecoder jwtDecoder = NimbusJwtDecoder
				.withSecretKey(key)
				.macAlgorithm(MacAlgorithm.HS256)
				.build();
		
		//[3]
		//토큰 변조, 만료 다 체크됨(예외발생)
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

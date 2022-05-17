package com.ssafit.util;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtill {
	private static final String SALT= "SSAFIT";
	public String createToken(String claimId, String data) throws Exception{
		return Jwts.builder()
				.setHeaderParam("alg", "HS256")
				.setHeaderParam("typ", "JWT")
				.claim(claimId, data)
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8"))
				.compact();
	}
	public void valid(String token) throws Exception{
		Jws<Claims> claims = Jwts.parser()
				.setSigningKey("SSAFIT".getBytes("UTF-8"))
				.parseClaimsJws(token);
	}
}

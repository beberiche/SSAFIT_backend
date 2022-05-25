package com.ssafit.util;

import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtill {
	private static final String SALT = "SSAFIT";
	private static final int AT_EXPIRATION = 1000 * 60 * 60 * 24;
	private static final int RT_EXPIRATION = 1000 * 60 * 60 * 24 * 30;

	public String createAccessToken(String claimId, String data) throws Exception {
		return Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT").claim(claimId, data)
				.setExpiration(new Date(System.currentTimeMillis() + AT_EXPIRATION))
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")).compact();
	}

//	public String createRefreshToken(String claimId, String data) throws Exception {
//		return Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT").claim(claimId, data)
//				.setExpiration(new Date(System.currentTimeMillis() + RT_EXPIRATION))
//				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")).compact();
//	}

	public HashMap<String, Object> valid(String token) throws Exception {
			Claims claims = Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(token).getBody();
			
			Date expiration = claims.get("exp", Date.class);
			String id = claims.get("userId", String.class);
			HashMap<String, Object> map = new HashMap<>();
			
			map.put("userId", id);
			map.put("exp", expiration);
			
			return map;
	}
}

package com.ssafit.interceptor;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafit.model.dto.User;
import com.ssafit.model.service.UserService;
import com.ssafit.util.JWTUtill;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JWTInterceptor implements HandlerInterceptor {
	private static final String ACCESS_TOKEN = "access-token";

	@Autowired
	public JWTUtill jwtUtill;

	@Autowired
	public UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 추가된 부분
		if (request.getMethod().equals("OPTIONS")) {
			return true;
		}

		final String accessToken = request.getHeader(ACCESS_TOKEN);
		// 0. 엑세스 토큰이 있는지 없는지 확인
		if (accessToken != null) {

			HashMap<String, Object> accessTokenData = jwtUtill.valid(accessToken);
	
			String atUserId = (String) accessTokenData.get("userId"); // 토큰이 가진 userId값
			Date atExp = (Date) accessTokenData.get("exp"); // 토큰 만료 날짜
			User user = userService.getUser(atUserId); // 토큰이 유효한지 비교할 유저데이터
			
			
//			userService.getUser(id);
			// 1. 받아온 엑세스 토큰이 동일한 토큰인지 확인
			try {
				// 2. 엑세스 토큰이 시간이 만료되었느지 확인
				if (atUserId.equals(user.getId()) && atExp.before(new Date(System.currentTimeMillis()))) {
					return true;
				}
			} catch (ExpiredJwtException e) {
				// 3. 엑세스 토큰의 시간이 만료되었다면, 리프레시 토큰을 확인
				HashMap<String, Object> refreshTokenData =  jwtUtill.valid(user.getRefreshToken());
				Date rftExp = (Date) refreshTokenData.get("exp"); // 토큰 만료 날짜
				
				// 4. 리프레시 토큰이 시간이 만료되었는지 확인
				if(rftExp.before(new Date(System.currentTimeMillis()))) {
					// 5. 리프레시 토큰이 만료되지 않았다면 엑세스 토큰 재생성하여 프론트로 전달
					response.setHeader("access-token", jwtUtill.createAccessToken("userId", user.getId()));
					return true;
				} else {
					return false;
				}		
			}




			// 7. 리프레시 마저 만료되었다면, 리프레시 토큰, 엑세스 토큰 재생성하여 각각 데이터베이스와 프론트로 전달.

		}
		throw new Exception("유효하지 않은 접근입니다.");
//		return false;
	}
}

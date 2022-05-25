package com.ssafit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafit.util.JWTUtill;


@Component
public class JWTInterceptor implements HandlerInterceptor {
	private static final String HEADER_AUTH = "auth-token";

	@Autowired
	public JWTUtill jwtUtill;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 추가된 부분
		if (request.getMethod().equals("OPTIONS")) {
			return true;
		}

		final String token = request.getHeader(HEADER_AUTH);
		System.out.println("token : " + token);
		if (token != null) {
			
			jwtUtill.valid(token);
			return true;
		}
		throw new Exception("유효하지 않은 접근입니다.");
	}

}

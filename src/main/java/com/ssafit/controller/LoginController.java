package com.ssafit.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.model.dto.User;
import com.ssafit.model.service.UserService;
import com.ssafit.util.JWTUtill;
import com.ssafit.util.SHA256;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private JWTUtill jwtUtill;

	@Autowired
	UserService userService;

	@PostMapping("")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		HttpStatus status = null;
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			User u = userService.getUser(user.getId());
			if (u != null && u.getId().equals(user.getId())  && u.getPassword().equals(user.getPassword()) ) {
				result.put("auth-token", jwtUtill.createToken("userId", user.getId()));
				result.put("message", SUCCESS);
				result.put("userData", u);
				status = HttpStatus.ACCEPTED;
			} else {
				result.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(result, status);

	}
}

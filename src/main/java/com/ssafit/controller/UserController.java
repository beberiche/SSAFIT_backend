package com.ssafit.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.model.dto.User;
import com.ssafit.model.service.FollowService;
import com.ssafit.model.service.LikeService;
import com.ssafit.model.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	@Autowired
	UserService userService;

	@Autowired
	LikeService likeService;

	@Autowired
	FollowService followService;

	// 유저등록
	@PostMapping("/")
	public ResponseEntity<String> insertUser(@RequestBody User user) {
		userService.insertUser(user);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
	}

	// 유저삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id) {
		if (userService.deleteUser(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	// 유저 수정
	@PutMapping("/")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	// 유저 상세
	@GetMapping("/{id}")
	public ResponseEntity<HashMap<String, Object>> detailUser(@PathVariable  String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user", userService.selectUser(id));
//		map.put("likes", likeService.selectList(id));
		map.put("follows", followService.selectList(id));
		return new ResponseEntity<HashMap<String, Object>>(map, HttpStatus.OK);
	}
}

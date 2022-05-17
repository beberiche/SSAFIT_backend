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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "유저 관련")
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
	@ApiOperation(
			value = "유저 등록",
			notes = "새로운 유저의 정보를 데이터베이스에 등록합니다."
	)
	public ResponseEntity<String> insertUser(@RequestBody User user) {
		userService.insertUser(user);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
	}

	// 유저삭제
	@DeleteMapping("/{id}")
	@ApiOperation(
			value = "유저 삭제",
			notes = "탈퇴한 유저의 정보를 데이터베이스에 삭제합니다."
	)
	public ResponseEntity<String> deleteUser(@PathVariable String id) {
		if (userService.deleteUser(id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	// 유저 수정
	@PutMapping("/")
	@ApiOperation(
			value = "유저 수정",
			notes = "유저 정보를 업데이트 합니다."
	)
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	// 유저 상세
	@GetMapping("/{id}")
	@ApiOperation(
			value = "유저 상세 조회",
			notes = "유저의 상세 정보를 보여줍니다."
	)
	public ResponseEntity<HashMap<String, Object>> detailUser(@PathVariable  String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user", userService.selectUser(id));
//		map.put("likes", likeService.selectList(id));
		map.put("follows", followService.selectList(id));
		return new ResponseEntity<HashMap<String, Object>>(map, HttpStatus.OK);
	}
}

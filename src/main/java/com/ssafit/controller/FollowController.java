package com.ssafit.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.model.dto.Follow;
import com.ssafit.model.service.FollowService;

@RestController
@RequestMapping("/api/follow")
public class FollowController {

	@Autowired
	FollowService followService;

	@PostMapping("/insert")
	public ResponseEntity<String> insertFollow(@RequestBody Follow follow) {
		followService.insertFollow(follow);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

	}

	@DeleteMapping("/{no}")
	public ResponseEntity<String> deleteFollow(@PathVariable int no) {
		followService.deleteFollw(no);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<List<Follow>> listFollow(@PathVariable String userId) {
		return new ResponseEntity<List<Follow>>(followService.selectList(userId), HttpStatus.OK);
	}
}

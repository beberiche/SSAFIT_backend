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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "팔로우 관련")
@RestController
@RequestMapping("/api/follow")
public class FollowController {

	@Autowired
	FollowService followService;

	@PostMapping("/")
	@ApiOperation(
			value = "팔로우 생성",
			notes = "원하는 유저의 id를 팔로우에 등록시킵니다."
	)
	public ResponseEntity<String> insertFollow(@RequestBody Follow follow) {
		followService.insertFollow(follow);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

	}

	@DeleteMapping("/{no}")
	@ApiOperation(
			value = "팔로우 삭제",
			notes = "선택한 유저를 더이상 팔로우하지 않습니다."
	)
	public ResponseEntity<String> deleteFollow(@PathVariable int no) {
		followService.deleteFollw(no);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	@ApiOperation(
			value = "팔로우 전체 조회",
			notes = "해당 유저의 팔로우 목록을 모두 보여줍니다."
	)
	public ResponseEntity<List<Follow>> listFollow(@PathVariable String userId) {
		return new ResponseEntity<List<Follow>>(followService.selectList(userId), HttpStatus.OK);
	}
}

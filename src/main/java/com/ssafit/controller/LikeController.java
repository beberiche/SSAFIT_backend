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
import com.ssafit.model.dto.Like;
import com.ssafit.model.service.FollowService;
import com.ssafit.model.service.LikeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags = "찜 관련")
@RestController
@RequestMapping("/api/like")
public class LikeController {

	@Autowired
	LikeService likeService;

	@PostMapping("/")
	@ApiOperation(
			value = "찜 등록",
			notes = "해당 비디오를 찜목록에 저장합니다."
	)
	public ResponseEntity<String> insertLike(@RequestBody Like like) {
		likeService.insertLike(like);
		;
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

	}

	@DeleteMapping("/{no}")
	@ApiOperation(
			value = "찜 삭제",
			notes = "해당 비디오를 찜목록에서 제거합니다."
	)
	public ResponseEntity<String> deleteLike(@PathVariable int no) {
		likeService.deleteLike(no);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	@ApiOperation(
			value = "찜 전체조회",
			notes = "해당 유저의 찜목록을 모두 보여줍니다."
	)
	public ResponseEntity<List<Like>> listLike(@PathVariable String userId) {
		return new ResponseEntity<List<Like>>(likeService.selectList(userId), HttpStatus.OK);
	}
}

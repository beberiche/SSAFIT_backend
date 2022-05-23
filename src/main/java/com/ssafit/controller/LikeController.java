package com.ssafit.controller;

import java.util.List;

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

import com.ssafit.model.dto.Like;
import com.ssafit.model.dto.Video;
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
		likeService.createLike(like);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

	}

	@DeleteMapping("/")
	@ApiOperation(
			value = "찜 삭제",
			notes = "해당 비디오를 찜목록에서 제거합니다."
	)
	public ResponseEntity<String> deleteLike(@RequestBody Like like) {
		likeService.removeLike(like);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	@ApiOperation(
			value = "찜 전체조회",
			notes = "해당 유저의 찜목록을 모두 보여줍니다."
	)
	public ResponseEntity<List<Like>> listLike(@PathVariable String userId) {
		return new ResponseEntity<List<Like>>(likeService.getListLike(userId), HttpStatus.OK);
	}
	
	
	@GetMapping("/videos/{userId}")
	@ApiOperation(
			value= "찜에 해당되는 비디오 정보 조회",
			notes = "찜에 해당되는 정보를 비디오 클래스로 변화시켜 반환합니다."
	)
	public ResponseEntity<List<Video>> listLikeVideo(@PathVariable String userId) {
		return new ResponseEntity<List<Video>>(likeService.getListLikeVideo(userId),HttpStatus.OK);
	}
}

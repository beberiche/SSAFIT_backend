package com.ssafit.controller;

import java.util.List;


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

import com.ssafit.model.dto.Comment;
import com.ssafit.model.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "댓글 관련")
@RestController
@RequestMapping("/api/comment")
public class CommentController {

	@Autowired
	CommentService commentService;

	// 작성
	@PostMapping("/")
	@ApiOperation(
			value = "댓글 등록",
			notes = "해당 비디오에 대한 댓글을 생성합니다."
	)
	public ResponseEntity<String> insertComment(@RequestBody Comment comment) {
		commentService.createComment(comment);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	// 수정
	@PutMapping("/")
	@ApiOperation(
			value = "댓글 수정",
			notes = "해당 댓글에 대한 정보를 수정합니다. 닉네임과 내용만 수정이 가능합니다."
	)
	public ResponseEntity<String> updateComment(@RequestBody Comment comment) {
		commentService.modifyComment(comment);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	// 삭제
	@DeleteMapping("/{id}")
	@ApiOperation(
			value = "댓글 삭제",
			notes = "해당 댓글을 데이터베이스에서 삭제합니다."
	)
	public ResponseEntity<String> deleteComment(@PathVariable int id) {
		commentService.removeComment(id);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	// 코멘트 리스트
	@GetMapping("/{id}")
	@ApiOperation(
			value = "댓글 전체 목록",
			notes = "해당 유튜브 아이디와 일치하는 모든 댓글을 목록을 보여줍니다."
	)
	public ResponseEntity<List<Comment>> readList(@PathVariable String id) {
		return new ResponseEntity<List<Comment>>(commentService.getListComment(id), HttpStatus.OK);

	}

	// 코멘트 상세
	@GetMapping("/detail/{id}")
	@ApiOperation(
			value = "댓글 상세 조회",
			notes = "해당 댓글 넘버와 일치하는 댓글의 정보를 모두 보여줍니다."
	)
	public ResponseEntity<Comment> readOne(@PathVariable int id) {
		return new ResponseEntity<Comment>(commentService.getOneComment(id), HttpStatus.OK);

	}
}

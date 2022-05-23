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

import com.ssafit.model.dto.SubComment;
import com.ssafit.model.service.SubCommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "대댓글 관련")
@RestController
@RequestMapping("/api/subcomment")
public class SubCommentController {

	@Autowired
	SubCommentService subCommentService;

	// 작성
	@PostMapping("/")
	@ApiOperation(value = "대댓글 등록", notes = "기존 댓글을 기반으로 하는 대댓글을 생성합니다.")

	public ResponseEntity<Integer> insertComment(@RequestBody SubComment subcomment) {
		
		subCommentService.createSubComment(subcomment);
		int id = subcomment.getSubNo();
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}

	// 수정
	@PutMapping("/")
	@ApiOperation(value = "대댓글 수정", notes = "해당 대댓글 정보를 수정합니다. 댓글과 마찬가지로, 닉네임과 내용만 수정이 가능합니다.")
	public ResponseEntity<String> updateComment(@RequestBody SubComment comment) {
		subCommentService.modifySubComment(comment);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	// 삭제
	@DeleteMapping("/{id}")
	@ApiOperation(value = "대댓글 삭제", notes = "해당 대댓글을 삭제합니다.")
	public ResponseEntity<String> deleteComment(@PathVariable int id) {
		subCommentService.removeSubComment(id);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	// 코멘트 리스트
	@GetMapping("/{id}")
	@ApiOperation(value = "대댓글 전체 목록", notes = "해당 댓글의 대댓글 정보 리스트를 반환합니다.")
	public ResponseEntity<List<SubComment>> readList(@PathVariable int id) {
		return new ResponseEntity<List<SubComment>>(subCommentService.getListSubComment(id), HttpStatus.OK);

	}

	// 코멘트 상세
	@GetMapping("/detail/{id}")
	@ApiOperation(value = "대댓글 상세", notes = "해당 대댓글의 상세 정보를 보여줍니다.")
	public ResponseEntity<SubComment> readOne(@PathVariable int id) {
		return new ResponseEntity<SubComment>(subCommentService.getOneSubComment(id), HttpStatus.OK);

	}
}

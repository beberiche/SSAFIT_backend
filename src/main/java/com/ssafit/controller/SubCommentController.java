package com.ssafit.controller;

import java.util.List;

import javax.xml.ws.Response;

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
import com.ssafit.model.dto.SubComment;
import com.ssafit.model.service.CommentService;
import com.ssafit.model.service.SubCommentService;

@RestController
@RequestMapping("/api/subcomment")
public class SubCommentController {

	@Autowired
	SubCommentService subCommentService;

	// 작성
	@PostMapping("/")
	public ResponseEntity<String> insertComment(@RequestBody SubComment comment) {
		subCommentService.insertSubComment(comment);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	// 수정
	@PutMapping("/")
	public ResponseEntity<String> updateComment(@RequestBody SubComment comment) {
		subCommentService.updateSubComment(comment);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	// 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable int id) {
		subCommentService.deleteSubComment(id);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	// 코멘트 리스트
	@GetMapping("/{id}")
	public ResponseEntity<List<SubComment>> readList(@PathVariable int id) {
		return new ResponseEntity<List<SubComment>>(subCommentService.selectList(id), HttpStatus.OK);

	}

	// 코멘트 상세
	@GetMapping("/detail/{id}")
	public ResponseEntity<SubComment> readOne(@PathVariable int id) {
		return new ResponseEntity<SubComment>(subCommentService.selectOne(id), HttpStatus.OK);

	}
}

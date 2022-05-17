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
import com.ssafit.model.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

	@Autowired
	CommentService commentService;

	// 작성
	@PostMapping("/")
	public ResponseEntity<String> insertComment(@RequestBody Comment comment) {
		commentService.InsertComment(comment);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	// 수정
	@PutMapping("/")
	public ResponseEntity<String> updateComment(@RequestBody Comment comment) {
		commentService.updateComment(comment);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	// 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable int id) {
		commentService.deleteComment(id);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	// 코멘트 리스트
	@GetMapping("/{id}")
	public ResponseEntity<List<Comment>> readList(@PathVariable String id) {
		return new ResponseEntity<List<Comment>>(commentService.selectList(id), HttpStatus.OK);

	}

	// 코멘트 상세
	@GetMapping("/detail/{id}")
	public ResponseEntity<Comment> readOne(@PathVariable int id) {
		return new ResponseEntity<Comment>(commentService.selectOne(id), HttpStatus.OK);

	}
}

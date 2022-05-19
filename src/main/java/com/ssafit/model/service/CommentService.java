package com.ssafit.model.service;

import java.util.List;

import com.ssafit.model.dto.Comment;

public interface CommentService {
		// comment 작성
		void createComment(Comment comment);
		// comment 삭제
		boolean removeComment(int commentNo);
		// comment 수정
		boolean modifyComment(Comment comment);
		// comment 조회
		// 전체 조회
		List<Comment> getListComment(String yotubeId);
		// 상세 보기
		Comment getOneComment(int commentNo);
}

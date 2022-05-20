package com.ssafit.model.dao;

import java.util.List;

import com.ssafit.model.dto.Comment;

public interface CommentDao {
	// comment 작성
	void insertComment(Comment comment);
	// comment 삭제
	boolean deleteComment(int commentNo);
	// comment 수정
	boolean updateComment(Comment comment);
	// comment 조회
	// 전체 조회
	List<Comment> selectListComment(String youtubeId);
	// 상세 보기
	Comment selectOneComment(int commentNo);
}

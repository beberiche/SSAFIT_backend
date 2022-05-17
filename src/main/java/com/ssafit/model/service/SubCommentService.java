package com.ssafit.model.service;

import java.util.List;

import com.ssafit.model.dto.SubComment;

public interface SubCommentService {

	// subcomment 작성
	void insertSubComment(SubComment subComment);

	// subcomment 삭제
	boolean deleteSubComment(int SubNo);

	// subcomment 수정
	boolean updateSubComment(SubComment subComment);

	// subcomment 조회
	// 전체 조회
	List<SubComment> selectList(int CommentNo);

	// 상세 조회
	SubComment selectOne(int SubNo);
}

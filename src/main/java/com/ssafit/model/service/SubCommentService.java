package com.ssafit.model.service;

import java.util.List;

import com.ssafit.model.dto.SubComment;

public interface SubCommentService {

	// subcomment 작성
	void createSubComment(SubComment subComment);

	// subcomment 삭제
	boolean removeSubComment(int subNo);

	// subcomment 수정
	boolean modifySubComment(SubComment subComment);

	// subcomment 조회
	// 전체 조회
	List<SubComment> getListSubComment(int commentNo);

	// 상세 조회
	SubComment getOneSubComment(int subNo);
}

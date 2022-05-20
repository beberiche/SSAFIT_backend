package com.ssafit.model.dao;

import java.util.List;

import com.ssafit.model.dto.SubComment;

public interface SubCommentDao {
	// subcomment 작성
	void insertSubComment(SubComment subComment);
	// subcomment 삭제
	boolean deleteSubComment(int subNo);
	// subcomment 수정
	boolean updateSubComment(SubComment subComment);
	// subcomment 조회
	// 전체 조회
	List<SubComment> selectListSubComment(int commentNo);
	// 상세 조회                   selectListSubComment
	SubComment selectOneSubComment(int subNo);
}

package com.ssafit.model.dao;

import java.util.List;

import com.ssafit.model.dto.Like;

public interface LikeDao {
	// like 등록
	void insertLike(Like like);
	// like 삭제
	boolean deleteLike(int no);
	
	// like 조회
	List<Like> selectListLike(String userId);
	
}

package com.ssafit.model.service;

import java.util.List;

import com.ssafit.model.dto.Like;

public interface LikeService {
	// like 등록
		void insertLike(Like like);
		// like 삭제
		boolean deleteLike(int no);
		
		// like 조회
		List<Like> selectList(String userId);
}

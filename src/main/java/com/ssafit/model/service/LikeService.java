package com.ssafit.model.service;

import java.util.List;

import com.ssafit.model.dto.Like;

public interface LikeService {
	// like 등록
		void createLike(Like like);
		// like 삭제
		boolean removeLike(int no);
		
		// like 조회
		List<Like> getListLike(String userId);
}

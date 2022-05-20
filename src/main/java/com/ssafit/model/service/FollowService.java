package com.ssafit.model.service;

import java.util.List;

import com.ssafit.model.dto.Follow;

public interface FollowService {
	// Follow 등록
		void createFollow(Follow follow);

		// Follow 삭제
		boolean removeFollw(String userid, String followid);

		// Follow 조회
		List<Follow> getListFollow(String userId);
}

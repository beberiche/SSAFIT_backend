package com.ssafit.model.service;

import com.ssafit.model.dto.User;

public interface UserService {
	// 유저 생성
	void createUser(User user);
	// 유저 삭제
	boolean removeUser(String id);
	// 유저 수정
	boolean modifyUser(User user);
	// 유저 조회
	User getUser(String id);
}

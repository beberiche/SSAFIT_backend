package com.ssafit.model.service;

import com.ssafit.model.dto.User;

public interface UserService {
	// 유저 생성
	void insertUser(User user);
	// 유저 삭제
	boolean deleteUser(String id);
	// 유저 수정
	boolean updateUser(User user);
	// 유저 조회
	User selectUser(String id);
}

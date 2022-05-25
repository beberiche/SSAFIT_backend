package com.ssafit.model.dao;

import com.ssafit.model.dto.User;

public interface UserDao {
	// 유저 등록
	void insertUser(User user);
	
	// 유저 삭제
	boolean deleteUser(String id);
	
	// 유저 수정
	boolean updateUser(User user);
	
	// 유저 조회
	User selectUser(String id);
	
	// 회원가입시 토큰 생성
	// insertUser에서 넣어주면 된다.
	
	// 만료된 토큰 재생성
	void updateRefreshToken(User user);

}

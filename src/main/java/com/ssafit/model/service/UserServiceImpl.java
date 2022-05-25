package com.ssafit.model.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.model.dao.UserDao;
import com.ssafit.model.dto.User;
import com.ssafit.util.JWTUtill;
import com.ssafit.util.SHA256;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	@Autowired
	JWTUtill jwtUtill;

	@Override
	public void createUser(User user) {
		try {
		userDao.insertUser(user);
		user.setRefreshToken(jwtUtill.createRefreshToken("userId", user.getId()));
		userDao.updateRefreshToken(user);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean removeUser(String id) {
		if(userDao.deleteUser(id))
			return true;
		return false;
	}

	@Override
	public boolean modifyUser(User user) {
		if(userDao.updateUser(user))
			return true;
		return false;
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return userDao.selectUser(id);
	}

	@Override
	public void modifyRefreshToken(User user) throws Exception {
		// TODO Auto-generated method stub
		user.setRefreshToken(jwtUtill.createRefreshToken("userId", user.getId()));
		userDao.updateRefreshToken(user);
	}	
}

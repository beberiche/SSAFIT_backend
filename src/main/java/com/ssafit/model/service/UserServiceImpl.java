package com.ssafit.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafit.model.dao.UserDao;
import com.ssafit.model.dto.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public boolean deleteUser(String id) {
		if(userDao.deleteUser(id))
			return true;
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		if(userDao.updateUser(user))
			return true;
		return false;
	}

	@Override
	public User selectUser(String id) {
		// TODO Auto-generated method stub
		return userDao.selecetUser(id);
	}

	
}

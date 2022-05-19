package com.ssafit.model.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.model.dao.UserDao;
import com.ssafit.model.dto.User;
import com.ssafit.util.SHA256;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	@Override
	public void insertUser(User user) throws Exception {
		user.setPassword(new SHA256().getHash(user.getPassword()));
		userDao.insertUser(user);
	}

	@Override
	public boolean deleteUser(String id) {
		if(userDao.deleteUser(id))
			return true;
		return false;
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		user.setPassword(new SHA256().getHash(user.getPassword()));
		if(userDao.updateUser(user))
			return true;
		return false;
	}

	@Override
	public User selectUser(String id) {
		// TODO Auto-generated method stub
		return userDao.selectUser(id);
	}

	
}

package com.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafit.model.dao.FollowDao;
import com.ssafit.model.dto.Follow;

public class FollowServiceImpl implements FollowService{

	@Autowired
	FollowDao followDao;
	
	@Override
	public void insertFollow(Follow follow) {
		followDao.insertFollow(follow);
	}

	@Override
	public boolean deleteFollw(int no) {
		if(followDao.deleteFollw(no))
			return true;
		return false;
	}

	@Override
	public List<Follow> selectList(String userId) {
		return followDao.selectList(userId);
	}

}

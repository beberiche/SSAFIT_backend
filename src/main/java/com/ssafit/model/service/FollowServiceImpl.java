package com.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.model.dao.FollowDao;
import com.ssafit.model.dto.Follow;

@Service
public class FollowServiceImpl implements FollowService{

	@Autowired
	FollowDao followDao;
	
	@Override
	public void createFollow(Follow follow) {
		followDao.insertFollow(follow);
	}

	@Override
	public boolean removeFollw(int no) {
		if(followDao.deleteFollow(no))
			return true;
		return false;
	}

	@Override
	public List<Follow> getListFollow(String userId) {
		return followDao.selectListFollow(userId);
	}

}

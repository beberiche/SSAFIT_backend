package com.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafit.model.dao.LikeDao;
import com.ssafit.model.dto.Like;

public class LikeServiceImpl implements LikeService {

	@Autowired
	LikeDao likeDao;
	@Override
	public void insertLike(Like like) {

		likeDao.insertLike(like);
	}

	@Override
	public boolean deleteLike(int no) {
		if(likeDao.deleteLike(no))
			return true;
		return false;
	}

	@Override
	public List<Like> selectList(String userId) {
		return likeDao.selectList(userId);
	}

}

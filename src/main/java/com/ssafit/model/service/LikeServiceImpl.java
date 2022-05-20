package com.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.model.dao.LikeDao;
import com.ssafit.model.dto.Like;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	LikeDao likeDao;
	@Override
	public void createLike(Like like) {
		likeDao.insertLike(like);
	}

	@Override
	public boolean removeLike(int no) {
		if(likeDao.deleteLike(no))
			return true;
		return false;
	}

	@Override
	public List<Like> getListLike(String userId) {
		return likeDao.selectListLike(userId);
	}

}

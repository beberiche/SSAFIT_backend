package com.ssafit.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.model.dao.LikeDao;
import com.ssafit.model.dao.VideoDao;
import com.ssafit.model.dto.Like;
import com.ssafit.model.dto.Video;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	LikeDao likeDao;
	
	@Autowired
	VideoDao videoDao;
	
	@Override
	public void createLike(Like like) {
		likeDao.insertLike(like);
	}

	@Override
	public boolean removeLike(Like like) {
		if(likeDao.deleteLike(like))
			return true;
		return false;
	}

	@Override
	public List<Like> getListLike(String userId) {
		return likeDao.selectListLike(userId);
	}
	
	@Override
	public List<Video> getListLikeVideo(String userId) {
		List<Like> likes = this.getListLike(userId);
		List<Video> videoList = new ArrayList<>();
		for(Like like : likes) {
			videoList.add(videoDao.selectOneVideo(like.getYoutubeId()));
		}
		return videoList;
	}

}

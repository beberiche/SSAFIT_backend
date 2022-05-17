package com.ssafit.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.model.dao.VideoDao;
import com.ssafit.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	VideoDao videoDao;
	
	@Override
	public List<Video> selecList(HashMap<String, String> params) {

		return videoDao.selectList(params);
	}

	@Override
	public Video selectOne(String id) {
		// TODO Auto-generated method stub
		return videoDao.selectOne(id);
	}

//	@Override
//	public void videoViewCountUp(String youtubeId) {
//		// TODO Auto-generated method stub
//		videoDao.viewCntUp(youtubeId);
//	}
	

}

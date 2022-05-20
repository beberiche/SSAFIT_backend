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
	public List<Video> getListVideo(HashMap<String, String> params) {

		return videoDao.selectListVideo(params);
	}

	@Override
	public Video getOneVideo(String id) {
		// TODO Auto-generated method stub
		videoDao.viewCntUp(id);
		return videoDao.selectOneVideo(id);
	}

	@Override
	public void viewCountUpVideo(String youtubeId) {
		// TODO Auto-generated method stub
		videoDao.viewCntUp(youtubeId);
	}
	

}

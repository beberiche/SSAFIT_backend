package com.ssafit.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafit.model.dao.VideoDao;
import com.ssafit.model.dto.Video;

public class VideoServiceImpl implements VideoService{

	@Autowired
	VideoDao videoDao;
	
	@Override
	public List<Video> selecList(HashMap<String, String> params) {

		return videoDao.selectLIst(params);
	}

	@Override
	public Video selectOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

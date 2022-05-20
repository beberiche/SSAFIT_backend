package com.ssafit.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafit.model.dto.Video;

public interface VideoDao {
	// 비디오 조회
	List<Video> selectListVideo(HashMap<String, String> params);
	
	// 비디오 상세
	Video selectOneVideo(String id);
	
	// 조회수 증가
	void viewCntUp(String id);
}

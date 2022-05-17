package com.ssafit.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafit.model.dto.Video;

public interface VideoService {
	// 비디오 조회
	List<Video> selecList(HashMap<String, String> params);
	
	// 비디오 상세
	Video selectOne(String id);
	
//	void videoViewCountUp(String youtubeId);
	
}

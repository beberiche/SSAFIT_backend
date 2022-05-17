package com.ssafit.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafit.model.dto.Video;

public interface VideoDao {
	// 비디오 조회
	List<Video> selectLIst(HashMap<String, String> params);
	
	// 비디오 상세
	Video selectOne(String id);
	
	
}

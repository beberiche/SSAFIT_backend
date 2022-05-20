package com.ssafit.model.dto;

import lombok.Data;

@Data
public class Comment {	
	private int commentNo;
	private String youtubeId;
	private String nickName;
	private String content;
	private String userId;
	private String date;
}

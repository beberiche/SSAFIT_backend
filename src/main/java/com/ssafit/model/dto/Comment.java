package com.ssafit.model.dto;

import lombok.Data;

@Data
public class Comment {	
	private int CommentNo;
	private String YoutubeId;
	private String NickName;
	private String Content;
	private String UserId;
	private String Date;
}

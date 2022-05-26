package com.ssafit.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "CommentDTO", description = "댓글 정보를 표현한다.")
public class Comment {	
	private int commentNo;
	private String youtubeId;
	private String nickName;
	private String content;
	private String userId;
	private String date;
}

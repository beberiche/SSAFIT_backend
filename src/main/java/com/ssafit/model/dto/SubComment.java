package com.ssafit.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "SubcommnetDTO", description = "대댓글 정보를 표현한다.")
public class SubComment {
	private int subNo;
	private int commentNo;
	private String nickName;
	private String content;
	private String userId;
	private String date;
}

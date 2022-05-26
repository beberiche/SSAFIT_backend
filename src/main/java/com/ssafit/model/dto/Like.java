package com.ssafit.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "LikeDTO", description = "좋아요 정보를 표현한다.")
public class Like {
	private int no;
	private String youtubeId;
	private String userId;
}

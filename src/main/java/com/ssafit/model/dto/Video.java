package com.ssafit.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "VideoDTO", description = "비디오 정보를 표현한다.")
public class Video {
	private String youtubeId;
	private String channelName;
	private String fitPartName;
	private String title;
	private int viewCnt;
}

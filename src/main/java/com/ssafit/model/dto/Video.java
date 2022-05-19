package com.ssafit.model.dto;

import lombok.Data;

@Data
public class Video {
	private String youtubeId;
	private String channelName;
	private String fitPartName;
	private String title;
	private int viewCnt;
}

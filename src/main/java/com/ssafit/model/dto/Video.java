package com.ssafit.model.dto;

import lombok.Data;

@Data
public class Video {
	private String YoutubeId;
	private String ChannelName;
	private String FitPartName;
	private String Title;
	private int ViewCnt;
}

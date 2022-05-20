package com.ssafit.model.dto;

import lombok.Data;

@Data
public class SubComment {
	private int subNo;
	private int commentNo;
	private String nickName;
	private String content;
	private String userId;
	private String date;
}

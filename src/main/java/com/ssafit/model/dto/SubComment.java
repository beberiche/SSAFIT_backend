package com.ssafit.model.dto;

import lombok.Data;

@Data
public class SubComment {
	private int SubNo;
	private int CommentNo;
	private String NickName;
	private String Content;
	private String UserId;
	private String Date;
}

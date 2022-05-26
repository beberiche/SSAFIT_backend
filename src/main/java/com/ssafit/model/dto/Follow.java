package com.ssafit.model.dto;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "FollowDTO", description = "팔로우 정보를 표현한다.")
public class Follow {
	private String userId;
	private String followId;
}

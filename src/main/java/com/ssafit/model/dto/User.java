package com.ssafit.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "UserDTO", description = "유저 정보를 표현한다.")
public class User {
	private String id;
	private String password;
	private String name;
	private int age;
}

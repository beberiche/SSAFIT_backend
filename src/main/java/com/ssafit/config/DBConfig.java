package com.ssafit.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@MapperScan(basePackages = "com.ssafit.model.dao")
public class DBConfig {

}

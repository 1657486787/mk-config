package com.suns.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {

	@GetMapping("/test")
	public Object test(){
		return new Date();
	}

	@Value("${default.url}")
	private String defaultUrl;//对应datasource-${profile}.properties配置文件中的属性
	
	@GetMapping("/defaultUrl")
	public String getDefaultUrl() {
		return this.defaultUrl;
	}

	@Value("${redis.host}")
	private String redisHost;//对应redis-${profile}.properties配置文件中的属性

	@GetMapping("/redisHost")
	public String redisHost(){
		return redisHost;
	}
	
}

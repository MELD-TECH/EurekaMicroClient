package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class TestService {

	@Autowired
	private EurekaClient client;
	
	@GetMapping("/test")
	public String sayHello() {
		return "Checking out Eureka Service ";
	}
	
	@GetMapping("/service-check")
	public String getRunningService() {
		
		InstanceInfo info = client.getApplication("EUREKACLIENT320")
				.getInstances().get(0);
		
		String app = info.getAppName();
		
		int port = info.getPort();
		
		return app + " " + port;
	}
}

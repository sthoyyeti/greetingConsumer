package com.hm.internal.ms.demo.greetingsConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class GreetingsConsumerApplication {

	@Autowired
	private GreetingConService greetingConService;

	public static void main(String[] args) {
		SpringApplication.run(GreetingsConsumerApplication.class, args);
	}


	@GetMapping("/gclient/sayHelloo")
	public String triggerSayHello(){
		return greetingConService.doSayHello();
	}


}




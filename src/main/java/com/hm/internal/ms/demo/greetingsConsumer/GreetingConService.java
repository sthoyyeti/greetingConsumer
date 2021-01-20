package com.hm.internal.ms.demo.greetingsConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class GreetingConService {
    @Autowired
    HelloClient client;

    @FeignClient("greetings")
    interface HelloClient {
        @GetMapping("/sayHello")
        String hello();
    }

    public String doSayHello(){
        return client.hello();
    }
}
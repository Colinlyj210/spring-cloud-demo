package com.darcy.providerclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@SpringBootApplication
public class ProviderClientApplication {

    @Value("${server.port}")
    String port;

    @Value("${hello}")
    String hello;

    public static void main(String[] args) {
        SpringApplication.run(ProviderClientApplication.class, args);
    }

    @RequestMapping("/port")
    public String getPort(String name){
        return "hi "+name+", my port is: "+ port;
    }

    @RequestMapping("/hello")
    public String getHello(){
        return hello;
    }
}

package com.darcy.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@EnableEurekaClient
@RestController
@SpringBootApplication
public class ClientApplication {

    @Value("${hello}")
    String hello;

    @Autowired
    ClientService clientService;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @RequestMapping("/hello")
    public String getHello(){
        return hello;
    }

    @RequestMapping("/darcy")
    public String getPort(){
        return clientService.getPort("darcy");
    }

}

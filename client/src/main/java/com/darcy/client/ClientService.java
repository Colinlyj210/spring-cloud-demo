package com.darcy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider-client",fallback = ClientServiceImpl.class)
public interface ClientService {
    @RequestMapping(value = "/port",method = RequestMethod.POST)
    String getPort(@RequestParam(value = "name") String name);
}

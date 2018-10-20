package com.darcy.client;

import org.springframework.stereotype.Component;

@Component
public class ClientServiceImpl implements ClientService {
    @Override
    public String getPort(String name) {
        return "error,获取端口失败！";
    }
}

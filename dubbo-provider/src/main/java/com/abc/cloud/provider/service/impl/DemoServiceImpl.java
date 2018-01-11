package com.abc.cloud.provider.service.impl;

import com.abc.cloud.iface.DemoService;

public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        return "Hello! this is DemoServiceImpl say hello to: "+name;
    }
}

package com.dhc.rpc.service.impl;

import com.dhc.rpc.service.HelloService;

/**
 * Created by DuHongcai on 2016/10/28.
 */
public class HelloServiceImpl implements HelloService {
    public String hello(String name) {
        return "hello "+name;
    }
}

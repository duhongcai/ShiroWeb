package com.dhc.rpc.service;

import com.dhc.rpc.framework.RpcFramework;
import com.dhc.rpc.service.impl.HelloServiceImpl;

/**
 * Created by DuHongcai on 2016/10/28.
 */
public class RpcProvice {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        System.out.println(service.hello("DHC"));
        RpcFramework.export(HelloService.class,1234);
    }
}

package com.dhc.rpc.custome;

import com.dhc.rpc.framework.RpcFramework;
import com.dhc.rpc.service.HelloService;

/**
 * Created by DuHongcai on 2016/10/28.
 */
public class RpcCustomer {
    public static void main(String[] args) throws Exception {
        HelloService service = RpcFramework.refer(HelloService.class,"127.0.0.1",1234);
        System.out.println(service.hello("dhc"));
    }
}

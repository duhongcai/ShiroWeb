package com.dhc.basicskill.Proxy.jdk;

import com.dhc.basicskill.Proxy.noProxy.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by DuHongcai on 2016/10/14.
 */
public class PermformanceHandler implements InvocationHandler{

    private Object target;

    public PermformanceHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName()+":"+method.getName()); // 开启监控
        method.invoke(target,args); //执行目标方法
        PerformanceMonitor.end(); // 关闭
        return target;
    }
}

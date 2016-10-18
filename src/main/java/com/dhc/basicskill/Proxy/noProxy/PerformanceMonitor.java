package com.dhc.basicskill.Proxy.noProxy;

/**
 * Created by DuHongcai on 2016/10/14.
 */
public class PerformanceMonitor {
    private static ThreadLocal<MethodPerformance> performanceMonitor = new ThreadLocal();

    public static void begin(String name){
        System.out.println("开始监控。。。");
        MethodPerformance methodPerformance = new MethodPerformance(name);
        performanceMonitor.set(methodPerformance);
    }

    public static void end(){
        System.out.println("监控结束...");
        MethodPerformance methodPerformance = performanceMonitor.get();
        methodPerformance.printPermformance();
    }
}

package basicKnow.Proxy.noProxy;

/**
 * Created by DuHongcai on 2016/10/14.
 */
public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod){
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPermformance(){
        end = System.currentTimeMillis();
        System.out.println(serviceMethod+"操作耗时："+(end-begin));
    }
}

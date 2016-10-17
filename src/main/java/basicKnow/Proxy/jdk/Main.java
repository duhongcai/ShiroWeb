package basicKnow.Proxy.jdk;

import basicKnow.Proxy.noProxy.ForumService;
import basicKnow.Proxy.noProxy.ForumServiceImpl;

import java.lang.reflect.Proxy;

/**
 * Created by DuHongcai on 2016/10/14.
 */
public class Main {
    public static void main(String[] args) {

        ForumService target = new ForumServiceImpl();
        PermformanceHandler handler = new PermformanceHandler(target);
        ForumService forumService = (ForumService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler
        );

        forumService.removeForm("Form");
        //forumService.removeSubmit("submit");
    }
}

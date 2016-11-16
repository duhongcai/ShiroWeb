package proxy.jdkDynimic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by DuHongcai on 2016/11/1.
 */
public class MyjdbProxy implements InvocationHandler {
    private UserService userService;

    public MyjdbProxy(UserService userService) {
        this.userService = userService;
    }

    public UserService craeteProxy(){
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),this);
        return userServiceProxy;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("save".equals(method.getName())){
            System.out.println("权限校验=====");
            return method.invoke(userService,args);
        }
        return method.invoke(userService,args);
    }
}

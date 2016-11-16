package proxy.cglib;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by DuHongcai on 2016/11/1.
 */
public class MyCglibProxy implements MethodInterceptor {
    private UserService userService;

    public MyCglibProxy(UserService userService) {
        this.userService = userService;
    }

    public UserService createProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(userService.getClass());
        enhancer.setCallback((Callback) this);
        UserService userServiceProxy = (UserService) enhancer.create();
        return userServiceProxy;
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        return null;
    }

}

package proxy.jdkDynimic;

import org.junit.Test;

/**
 * Created by DuHongcai on 2016/11/1.
 */
public class SpringDemo {
    @Test
    public void demo1(){
        UserService service1 = new UserServiceImpl();
        service1.save();
        service1.delete();
        service1.update();
        service1.query();
    }
    @Test
    public void demo2(){
        UserService service = new UserServiceImpl();
        UserService proxy = new MyjdbProxy(service).craeteProxy();
        proxy.save();
        proxy.delete();
        proxy.update();
        proxy.delete();
    }

}

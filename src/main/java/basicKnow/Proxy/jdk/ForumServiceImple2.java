package basicKnow.Proxy.jdk;

import basicKnow.Proxy.noProxy.ForumService;

/**
 * Created by DuHongcai on 2016/10/14.
 */
public class ForumServiceImple2 implements ForumService {
    public void removeSubmit(String name) {
        System.out.println("模拟删除"+name);
        try{
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeForm(String name) {
        System.out.println("模拟删除"+name);
        try{
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

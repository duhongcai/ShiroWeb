package basicKnow.Proxy.noProxy;

/**
 * Created by DuHongcai on 2016/10/14.
 */
public class ForumServiceImpl implements ForumService {

    public void removeSubmit(String name) {
        PerformanceMonitor.begin("con.yaoyaohao.task------this is from removeSubmit");
        try{
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        PerformanceMonitor.end();
    }

    public void removeForm(String name) {
        PerformanceMonitor.begin("com.yaoyaohao.task-------this is from removeForm");
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        PerformanceMonitor.end();
    }
}

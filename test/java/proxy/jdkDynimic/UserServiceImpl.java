package proxy.jdkDynimic;

/**
 * Created by DuHongcai on 2016/11/1.
 */
public class UserServiceImpl implements UserService {
    public void save() {
        System.out.println("保存客户。。。。");
    }

    public void update() {
        System.out.println("更新客户。。。。");
    }

    public void delete() {
        System.out.println("删除客户。。。。");
    }

    public void query() {
        System.out.println("查询客户。。。。");
    }
}

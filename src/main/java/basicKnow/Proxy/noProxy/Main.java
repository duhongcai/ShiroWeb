package basicKnow.Proxy.noProxy;

/**
 * Created by DuHongcai on 2016/10/14.
 */
public class Main {
    public static void main(String[] args) {
        ForumService forumService = new ForumServiceImpl();
        forumService.removeSubmit("submit");
        forumService.removeForm("from");
    }
}

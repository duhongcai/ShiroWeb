import com.dhc.entry.LogInfo;
import com.dhc.service.LogRecoderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by DuHongcai on 2016/11/16.
 */
public class LogRecoderTest extends BasicTest {
    @Autowired
    private LogRecoderService logRecoderService;

    @Test
    public void testInsertLog(){
        LogInfo logInfo = new LogInfo();
        logInfo.setLoginAccount("duhc");
        logInfo.setBroswer("Chrome");
        logInfo.setRemark("手工添加");
        logInfo.setOerateTime(new Date());
        logRecoderService.insertLog(logInfo);
        System.out.println(logInfo.getOperateId());
    }
}

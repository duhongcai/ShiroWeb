import com.dhc.dto.OrderParam;
import com.dhc.entry.QualityPaper;
import com.dhc.service.QualityService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DuHongcai on 2016/10/19.
 */
public class QualityTest extends BasicTest {
    @Autowired
    private QualityService qualityService;

    @Test
    public void getQulityCus(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("offset","50");
        map.put("limit","10");
        List<QualityPaper> qualityPapers = qualityService.getAllQualirtyCus(map);
        for (QualityPaper qualityPaper:qualityPapers){
        }
    }
}

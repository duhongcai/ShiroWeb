package com.dhc.service.impl;

import com.dhc.dao.QulityDao;
import com.dhc.dto.OrderParam;
import com.dhc.entry.QualityPaper;
import com.dhc.service.QualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by DuHongcai on 2016/10/19.
 */
@Service
public class QualityServiceImpl implements QualityService {
    @Autowired
    private QulityDao qulityDao;
    public List<QualityPaper> getAllQualirtyCus(Map<String,Object> params) {
        OrderParam orderParam = new OrderParam();
        int offset =  Integer.valueOf(params.get("offset").toString());
        int limit = Integer.valueOf(params.get("limit").toString());
            orderParam.setOffset(offset);
            orderParam.setLimit(limit);

        return qulityDao.getAllQualirtyCus(orderParam);
    }

    public int getCnt() {
        return qulityDao.getCnt();
    }
}

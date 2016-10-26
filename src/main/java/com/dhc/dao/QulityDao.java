package com.dhc.dao;

import com.dhc.dto.OrderParam;
import com.dhc.entry.QualityPaper;

import java.util.List;

/**
 * Created by DuHongcai on 2016/10/19.
 */
public interface QulityDao {
    public List<QualityPaper> getAllQualirtyCus(OrderParam orderParam);
    public int getCnt();
}

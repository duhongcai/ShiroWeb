package com.dhc.service;

import com.dhc.entry.QualityPaper;

import java.util.List;
import java.util.Map;

/**
 * Created by DuHongcai on 2016/10/19.
 */
public interface QualityService {
    public List<QualityPaper> getAllQualirtyCus(Map<String,Object> params);
    public int getCnt();
}

package com.dhc.service;

import com.dhc.entry.LogInfo;

import java.util.List;

/**
 * Created by DuHongcai on 2016/11/16.
 */
public interface LogRecoderService {
    public void insertLog(LogInfo logInfo);
    public List<LogInfo> queryLogInfo();
}

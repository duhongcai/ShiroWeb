package com.dhc.dao;

import com.dhc.entry.LogInfo;

import java.util.List;

/**
 * Created by DuHongcai on 2016/11/16.
 */
public interface LogRecoderDao {
    public void insertLogService(LogInfo logInfo);
    public List<LogInfo> queryLogInfo();
}

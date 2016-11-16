package com.dhc.service.impl;

import com.dhc.dao.LogRecoderDao;
import com.dhc.entry.LogInfo;
import com.dhc.service.LogRecoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DuHongcai on 2016/11/16.
 */
@Service
public class LogRecoderServiceImpl implements LogRecoderService {
    @Autowired
    private LogRecoderDao logRecoderDao;
    public void insertLog(LogInfo logInfo) {
        logRecoderDao.insertLogService(logInfo);
    }

    public List<LogInfo> queryLogInfo() {
        return null;
    }
}

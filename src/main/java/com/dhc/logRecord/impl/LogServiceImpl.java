package com.dhc.logRecord.impl;

import com.dhc.logRecord.LogService;
import com.dhc.logRecord.entity.Log;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by DuHongcai on 2016/11/15.
 */
@Service
public class LogServiceImpl implements LogService {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(LogServiceImpl.class);
    public void add(Log log) {
        System.out.print(log.getLogId());
        System.out.print(log.getDescription());
        System.out.println(log.getMethod());
        System.out.println(log.getUsername());
    }
}

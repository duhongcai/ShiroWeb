package com.dhc.logRecord.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by DuHongcai on 2016/11/15.
 */
public class Log implements Serializable{
    private String logId;
    private String description;
    private String type;
    private String requestIp;
    private String method;
    private String params;
    private Date  createDate;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId='" + logId + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", requestIp='" + requestIp + '\'' +
                ", method='" + method + '\'' +
                ", params='" + params + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}

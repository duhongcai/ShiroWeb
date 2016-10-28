package com.dhc.entry;

import java.io.Serializable;

/**
 * Created by DuHongcai on 2016/10/27.
 */
public class Order implements Serializable {
    private String pageCode;
    private String cusName;
    private String checkTime;
    private String cusType;
    private String reservStr1;
    private int reserV;

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getCusType() {
        return cusType;
    }

    public void setCusType(String cusType) {
        this.cusType = cusType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Order)) return  false;
        Order that = (Order) obj;
        if (!this.getPageCode().equals(that.getPageCode())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 31;
        if (getPageCode()!=null) result = result + getPageCode().hashCode();
        return result;
    }
}

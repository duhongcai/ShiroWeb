package com.dhc.entry;

import java.io.Serializable;

/**
 * Created by DuHongcai on 2016/10/19.
 */
public class QualityPaper implements Serializable {
    private String cusId;
    private String cusCode;
    private String cusName;
    private String cusProvices;
    private String cusLinkMan; //业务员
    private String cusType;

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusProvices() {
        return cusProvices;
    }

    public void setCusProvices(String cusProvices) {
        this.cusProvices = cusProvices;
    }

    public String getCusLinkMan() {
        return cusLinkMan;
    }

    public void setCusLinkMan(String cusLinkMan) {
        this.cusLinkMan = cusLinkMan;
    }

    public String getCusType() {
        return cusType;
    }

    public void setCusType(String cusType) {
        this.cusType = cusType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QualityPaper that = (QualityPaper) o;

        if (cusId != null ? !cusId.equals(that.cusId) : that.cusId != null) return false;
        if (cusCode != null ? !cusCode.equals(that.cusCode) : that.cusCode != null) return false;
        return cusName != null ? cusName.equals(that.cusName) : that.cusName == null;

    }

    @Override
    public int hashCode() {
        int result = cusId != null ? cusId.hashCode() : 0;
        result = 31 * result + (cusCode != null ? cusCode.hashCode() : 0);
        result = 31 * result + (cusName != null ? cusName.hashCode() : 0);
        return result;
    }
}

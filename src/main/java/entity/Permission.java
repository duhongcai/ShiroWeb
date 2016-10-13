package entity;

import java.io.Serializable;

/**
 * Created by DuHongcai on 2016/10/12.
 */
public class Permission implements Serializable {
    private String perName;
    private String operaName;

    public Permission() {
    }

    public Permission(String perName, String operaName) {
        this.perName = perName;
        this.operaName = operaName;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public String getOperaName() {
        return operaName;
    }

    public void setOperaName(String operaName) {
        this.operaName = operaName;
    }
}

package com.dhc.entry;

import java.io.Serializable;

/**
 * Created by DuHongcai on 2016/10/17.
 */
public class Role implements Serializable {
    private String id;
    private String roleName;
    private String description;
    private String available;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Role)) return false;
        Role that = (Role) obj;
        if (this.roleName.equals(that.getRoleName())&&this.description.equals(that.description)
                &&this.id.equals(that.id)&&this.available.equals(that.getAvailable())) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = 31;
        if (id!=null) result = id.hashCode() + result;
        if (roleName!= null) result = roleName.hashCode() + result;
        if (description!=null) result = description.hashCode() + result;
        return result;
    }

    @Override
    public String toString() {
        return roleName;
    }
}

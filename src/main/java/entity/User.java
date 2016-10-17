package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DuHongcai on 2016/10/12.
 */
public class User implements Serializable {
    private String loginName;
    private String name;
    private List<Role> roles;

    public User() {
    }

    public User(String loginName, String name) {
        this.loginName = loginName;
        this.name = name;
    }

    public User(String loginName, String name, List<Role> roles) {
        this.loginName = loginName;
        this.name = name;
        this.roles = roles;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        if (roles == null){
            roles = new ArrayList<Role>();
        }
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
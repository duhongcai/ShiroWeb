package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DuHongcai on 2016/10/12.
 */
public class Role implements Serializable {
    private String roleName;
    private List<Permission> permissions;

    public Role() {
    }

    public Role(String roleName, List<Permission> permissions) {
        this.roleName = roleName;
        this.permissions = permissions;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Permission> getPermissions() {
        if (permissions == null){
            permissions = new ArrayList<Permission>();
        }
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}

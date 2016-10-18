package com.dhc.overclass;

import com.dhc.dto.Permission;
import com.dhc.dto.Role;
import com.dhc.dto.User;
import com.dhc.exception.CaptcacheException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DuHongcai on 2016/10/12.
 */
public class ShiroDbRealm extends AuthorizingRealm {

    Map<String,ShiroUser> shiroUserMap = new HashMap<String, ShiroUser>();
    Map<String,List<String>> userRoles= new HashMap<String, List<String>>();
    Map<String,User> userMap = new HashMap<String, User>();
    List<String> roles = new ArrayList<String>();

    Map<String, Role> roleMap = new HashMap<String, Role>();
    List<Permission> permissionList = new ArrayList<Permission>();
    {
        shiroUserMap.put("du",new ShiroUser("du","123"));
        shiroUserMap.put("liu",new ShiroUser("liu","123"));
        permissionList.add(new Permission("user","create"));
        roleMap.put("admin",new Role("admin",permissionList));
        roles.add("admin");
        userMap.put("du",new User("du","Drew"));
        userRoles.put("du",roles);
    }

    //赋权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName()).iterator().next();
        User user = userMap.get(shiroUser.getUsername());
        if (user!=null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addStringPermission("admin");
            return info;
        }
        return null;
    }

    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordCaptcaheToken token1 = (UsernamePasswordCaptcaheToken) token;

        String captcahe = token1.getDefaultCaptcaheName();
        String existCap = (String) SecurityUtils.getSubject().getSession().getAttribute("SE_KEY_MM_CODE");
        if (captcahe==null || captcahe.equals("") || !captcahe.equalsIgnoreCase(existCap)) throw new CaptcacheException("请输入正确验证码");
        String username = (String) token.getPrincipal();
        String password = token.getCredentials().toString();

        if (!shiroUserMap.containsKey(username)){
                throw new CaptcacheException("用户不存在");
        }
        ShiroUser user = shiroUserMap.get(username);
        return new SimpleAuthenticationInfo(new ShiroUser(username,password),user.getPassword(),getName());
    }
}

class ShiroUser{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ShiroUser() {
    }

    public ShiroUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ShiroUser)) return false;
        ShiroUser that = (ShiroUser) obj;
        if (username.equals(that.username)&&password.equals(that.password)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (username!=null && !username.equals("")) result = result*31+username.hashCode();
        if (password!= null && !password.equals("")) result = result*31+password.hashCode();
        return result;
    }
}

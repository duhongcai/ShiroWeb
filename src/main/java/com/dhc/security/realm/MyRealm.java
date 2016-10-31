package com.dhc.security.realm;

import com.dhc.dto.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by DuHongcai on 2016/10/18.
 */
public class MyRealm extends AuthorizingRealm {

    //赋权鉴权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("This is from MyRealm");
        User user = (User) getAvailablePrincipal(principals);
        String username = user.getLoginName();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //权限 -- -使用set 防重复 <对象需重写equal和hasCode>
        Set<String> s = new HashSet<String>();
        s.add("user:order:read");
        s.add("user:order:out");
        info.setStringPermissions(s);
        //角色
        Set<String> r = new HashSet<String>();
        r.add("role");
        r.add("admin");
        info.setRoles(r);
        return info;
    }

    //登录验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        String username = token1.getUsername();
        String password = new String(token1.getPassword());
        User user = new User(username,password);
        if (username.equals("du")&&password.equals("123")){
            return new SimpleAuthenticationInfo(user,password,getName());
        }
        return null;
    }
}

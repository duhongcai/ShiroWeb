package com.dhc.security.realm;

import com.dhc.dto.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by DuHongcai on 2016/10/18.
 */
public class MyRealm extends AuthorizingRealm {

    //赋权鉴权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
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

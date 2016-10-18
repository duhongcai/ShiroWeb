package com.dhc.overclass;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by DuHongcai on 2016/10/12.
 */
public class UsernamePasswordCaptcaheToken extends UsernamePasswordToken {
    private  String  captche;

    public  String getDefaultCaptcaheName() {
        return captche;
    }

    public  void setDefaultCaptcaheName(String captcaheName) {
        captche = captcaheName;
    }

    public UsernamePasswordCaptcaheToken(){super();}

    public UsernamePasswordCaptcaheToken(String username, String password, boolean rememberMe, String host, String captche){
        super(username,password,rememberMe,host);
        this.captche = captche;
    }

}

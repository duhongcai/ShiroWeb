package exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Created by DuHongcai on 2016/10/12.
 */
public class CaptcacheException extends AuthenticationException{

    public CaptcacheException(){
        super();
    }

    public CaptcacheException(String msg){super(msg);}

    public CaptcacheException(String msg,Exception e){super(msg,e);}

    public CaptcacheException(Throwable cause){super(cause);}

    public CaptcacheException(String msg,Throwable throwable){super(msg,throwable);}

}

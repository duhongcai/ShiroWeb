package overClass;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by DuHongcai on 2016/10/12.
 */
public class FormAuthenticationCaptcacheAutherFilter extends FormAuthenticationFilter {

    private String capatchParam = "capatcha";

    public String getCapatchParam() {
        return capatchParam;
    }

    protected String getCaptch(HttpServletRequest request){
        return  WebUtils.getCleanParam(request,getCapatchParam());
    }

    protected boolean getIsRemember(HttpServletRequest request){
        return isRememberMe(request);
    }

    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response){
        return  new UsernamePasswordCaptcaheToken(
                getUsername(request),
                getPassword(request),
                isRememberMe(request),
                getHost(request),
                getCaptch((HttpServletRequest) request)
        );
    }

}

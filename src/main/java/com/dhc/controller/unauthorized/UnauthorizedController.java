package com.dhc.controller.unauthorized;

import com.dhc.utils.ShiroWebUtil;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by DuHongcai on 2016/10/27.
 */
@ControllerAdvice
public class UnauthorizedController {
    private final static Logger logger = org.slf4j.LoggerFactory.getLogger(UnauthorizedController.class);

   @ExceptionHandler(UnauthorizedException.class)
    public ModelAndView toUnauthorizedPage(AuthorizationException ex, HttpServletRequest request, HttpServletResponse response){
        String pathInfo = request.getPathInfo();
        //判断是否是ajax请求
       if (ShiroWebUtil.ajax(request)){
           ShiroWebUtil.sendJson(request,response,new HashMap<String, Object>());
       }
       return new ModelAndView();
    }
}

package com.dhc.logRecord.anno;

import com.alibaba.druid.support.json.JSONUtils;
import com.dhc.logRecord.LogService;
import com.dhc.logRecord.SystemControllerLog;
import com.dhc.logRecord.SystemServliceLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * Created by DuHongcai on 2016/11/15.
 */
    @Aspect
    @Component
public class SystemLogAspect {
    @Autowired
    private LogService logService;

    /**
     * 定义切入点
     */

    @Pointcut("@annotation(com.dhc.logRecord.SystemControllerLog)")
    public void controllerAspect(){}

    @Pointcut("@annotation(com.dhc.logRecord.SystemServliceLog)")
    public void serviceAspect(){}


    /**
     * 定义注解解析方法
     * @param joinPoint
     * @return
     * @throws ClassNotFoundException
     */

    //获取Service方法的注解描述
    public static String getServiceMethodDescription(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method:methods){
            if (method.getName().equals(methodName)){
                Class[] clazz = method.getParameterTypes();
                if (clazz.length == arguments.length){
                    description = method.getAnnotation(SystemServliceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

    //获取Controller方法的注解描述
    public static String getControllerDescription(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method:methods){
            Class[] clazz = method.getParameterTypes();
            if (clazz.length == arguments.length){
                description = method.getAnnotation(SystemControllerLog.class).description();
                break;
            }
        }
        return description;
    }

    /**
     * 拦截切点进行日志记录
     * @param joinPoint
     */

    @Before("controllerAspect()")
    public void doBeforeController(JoinPoint joinPoint){
        HttpServletRequest request = (HttpServletRequest) RequestContextHolder.getRequestAttributes();
        HttpSession session = request.getSession();

        String ip = request.getRemoteAddr();
        try{
            System.out.println("===控制层前置通知开始===");
            System.out.println("请求方法为："+joinPoint.getTarget().getClass().getName()+"."
                    +joinPoint.getSignature().getName()+"()");
            System.out.println("方法描述："+getControllerDescription(joinPoint));
            System.out.println("请求IP："+ip);
            System.out.println("===控制层前置通知结束===");
        }catch (Exception e){
            System.out.println("===控制层前置通知异常===");
            e.printStackTrace();
        }
    }

    @Before("serviceAspect()")
    public void doBeforeService(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getRemoteAddr();
        try{
            System.out.println("===服务层前置通知开始===");
            System.out.println("调用方法为："+joinPoint.getTarget().getClass().getName()+"."+
                                joinPoint.getSignature().getName()+"()");
            System.out.println("方法描述:"+getServiceMethodDescription(joinPoint));
            System.out.println("请求IP:"+ip);
            System.out.println("===服务层前置通知结束===");
        }catch (Exception e){
            System.out.println("===服务层前置通知异常===");
            e.printStackTrace();
        }

    }

    @AfterThrowing(pointcut = "serviceAspect()",throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint,Throwable e){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getRemoteAddr();
        String params = "";
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0){
            for (int i=0;i<joinPoint.getArgs().length;i++){
                params += JSONUtils.toJSONString(joinPoint.getArgs()[i]+";");
            }
        }
        try{
            System.out.println("===异常通知开始===");
            System.out.println("异常代码:"+e.getClass().getName());
            System.out.println("异常信息:"+e.getMessage());
            System.out.println("异常方法:"+(joinPoint.getTarget().getClass().getName())+"."
                    +joinPoint.getSignature()+"()");
            System.out.println("方法描述："+getServiceMethodDescription(joinPoint));
            System.out.println("请求IP:"+ip);
            System.out.println("请求参数:"+params);
            System.out.println("===异常通知结束===");
        }catch (Exception ex){
            System.out.println("===异常通知异常===");
            ex.printStackTrace();
        }
    }


}

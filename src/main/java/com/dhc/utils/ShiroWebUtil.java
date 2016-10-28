package com.dhc.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;

/**
 * Created by DuHongcai on 2016/10/27.
 */
public class ShiroWebUtil {
    public static void sendJson(ServletResponse response,Object message)  {
        try{
            response.setContentType("text/plain;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(JSON.toJSON(message));
            out.flush();
            out.close();
        }catch (Exception e){
            System.out.println("SerletResponse返回JSON相应报错了");
        }
    }
}

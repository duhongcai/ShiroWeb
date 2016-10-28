package com.dhc.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DuHongcai on 2016/10/27.
 */
public class ShiroWebUtil {
    private static final Logger logger = LoggerFactory.getLogger(ShiroWebUtil.class);

    //判断是否ajax请求
    public static boolean ajax(HttpServletRequest request) {
        if (request.getHeader("X-Requested-With").equals("XMLHttpRequest")) {
            // 请求头中是否含有 X-Requested-With 属性，如果含有且属性值为XMLHttpRequest即可判定为ajax请求，ajax请求返回时值需要是一段JSON
            return true;
        }
        return false;
    }

    public static void sendJson(ServletResponse response, Object message) {
        try {
            response.setContentType("text/plain;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(JSON.toJSON(message));
            out.flush();
            out.close();
        } catch (Exception e) {
            System.out.println("SerletResponse返回JSON相应报错了");
        }
    }

    public static void sendJson(ServletRequest request, HttpServletResponse response, Map<String,Object> param) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            response.setContentType("text/plain;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            params.put("status","failure");
            params.put("code","9004");
            params.put("message","没有访问权限");

            PrintWriter out = response.getWriter();
            out.write(JSON.toJSONString(params));
            out.flush();
            out.close();
        } catch (Exception e) {
            logger.info("DHC", "ServletResponse返回JSON出错");
        }
    }
}

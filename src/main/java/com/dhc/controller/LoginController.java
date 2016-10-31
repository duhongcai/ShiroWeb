package com.dhc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by DuHongcai on 2016/10/11.
 */
//@WebServlet(name = "loginServlet",urlPatterns = "/login")
@Controller
@RequestMapping(value = "/")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String tologin(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, HttpServletResponse response, org.springframework.ui.Model model) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String captcha = request.getParameter("capatcha");
        String exiCap = (String) session.getAttribute("SE_KEY_MM_CODE");
        if (!captcha.equalsIgnoreCase(exiCap)) {
            model.addAttribute("error", "验证码错误");
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            return "/login";
        }
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subjcet = SecurityUtils.getSubject();
            subjcet.login(token);
            if (subjcet.isAuthenticated()) {
                return "/index";
            }
        } catch (Exception e) {
            model.addAttribute("error","用户名或者密码错误");
           return "/login";
        }
        return null;
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String captcha = request.getParameter("capatcha");
//        String remember = request.getParameter("remember");
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        Subject subject = SecurityUtils.getSubject();
//        Session session = subject.getSession(true);
//        String existCap = (String) session.getAttribute("SE_KEY_MM_CODE");
//        request.setAttribute("username", username);
//        request.setAttribute("password", password);
//        if (!StringUtils.hasText(captcha) || !StringUtils.hasText(existCap) || !existCap.equalsIgnoreCase(captcha)) {
//            //throw new CaptcacheException("验证码不正确");
//            request.setAttribute("error", "验证码不正确");
//            //request.getRequestDispatcher("/login.jsp").forward(request,response);
//            return "";
//        }
//        if (StringUtils.hasText(remember) && remember.equals("1")) {
//            token.setRememberMe(true);
//        }
//        try {
//            subject.login(token);
//            if (subject.hasRole("admin")) {
//                System.out.println("admin用户");
//            }
//            //request.getRequestDispatcher("/index.jsp").forward(request,response);
//            response.sendRedirect("index");
//        } catch (Exception e) {
//            request.setAttribute("error", "用户名或者密码错误");
//            //request.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(request,response);
//        }
    }
}

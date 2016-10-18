package com.dhc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DuHongcai on 2016/10/12.
 */
//@WebServlet(name = "logout",urlPatterns = "/logoutt")
@Controller
@RequestMapping(value = "/")
public class LogoutController {
    @RequestMapping(value = "/logout")
    public String logout(){
        return "logout";
    }
}

package com.dhc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DuHongcai on 2016/10/13.
 */
//@WebServlet(name = "indexServlet",urlPatterns = "/index"
//@Controller
//@RequestMapping(value = "/")
public class IndexController  {
    @RequestMapping(value = "/index")
    public String toIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "index";
    }
}

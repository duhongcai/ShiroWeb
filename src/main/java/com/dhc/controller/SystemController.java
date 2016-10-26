package com.dhc.controller;

import com.dhc.entry.QualityPaper;
import com.dhc.service.QualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by DuHongcai on 2016/10/19.
 */
@Controller
@RequestMapping(value = "/system")
public class SystemController extends BaseController {
    @Autowired
    private QualityService qualityService;

    @RequestMapping(value = "/orderList")
    public String getOrderList(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "orders";
    }

    @RequestMapping(value = "/initTime")
    @ResponseBody
    public Map<String,Object> initTime(){
        Map<String,Object> result = new HashMap<String, Object>();
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.CHINESE);
        Date thedate = new Date();
        result.put("today",formatter.format(thedate));
        result.put("lastDay",formatter.format(thedate));
        return result;
    }

    //bootstrspTable 需参
    @RequestMapping(value = "/initDate")
    @ResponseBody
    public Map<String, Object> initDate(HttpServletRequest request, Model model, @RequestParam Map<String, Object> param) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", qualityService.getCnt());
        int offset = Integer.valueOf(param.get("offset").toString());
        int limit = Integer.valueOf(param.get("limit").toString());
        List<QualityPaper> qualityPapers = qualityService.getAllQualirtyCus(param);
        map.put("page", (offset / limit));
        map.put("offset", offset);
        map.put("rows", qualityPapers);
        return map;
    }
}

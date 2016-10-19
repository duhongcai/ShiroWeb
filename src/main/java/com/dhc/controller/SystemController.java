package com.dhc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DuHongcai on 2016/10/19.
 */
@Controller
@RequestMapping(value = "/system")
public class SystemController {
    @RequestMapping(value = "/orderList")
    public String getOrderList(){
        return "orders";
    }
}

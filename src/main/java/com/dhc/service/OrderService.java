package com.dhc.service;

import com.dhc.entry.Order;
import com.dhc.entry.QualityPaper;

import java.util.List;
import java.util.Map;

/**
 * Created by DuHongcai on 2016/10/27.
 */
public interface OrderService {
    public List<Order> getOrderInfo(Map<String,Object> params);
    public int getOrderCnt(Map<String,Object> params);
}

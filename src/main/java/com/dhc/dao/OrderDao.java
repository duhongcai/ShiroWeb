package com.dhc.dao;

import com.dhc.entry.Order;
import com.dhc.entry.QualityPaper;

import java.util.List;
import java.util.Map;

/**
 * Created by DuHongcai on 2016/10/27.
 */
public interface OrderDao {
    public List<Order> getOrderInfo(Map<String,Object> params);
    public int getOrderCnt(Map<String,Object> params);
}

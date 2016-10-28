package com.dhc.service.impl;

import com.dhc.dao.OrderDao;
import com.dhc.entry.Order;
import com.dhc.entry.QualityPaper;
import com.dhc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by DuHongcai on 2016/10/27.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    public List<Order> getOrderInfo(Map<String, Object> params) {
        return orderDao.getOrderInfo(params);
    }

    public int getOrderCnt(Map<String, Object> params) {
        return orderDao.getOrderCnt(params);
    }
}

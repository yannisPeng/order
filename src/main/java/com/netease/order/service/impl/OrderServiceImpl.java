/**
 * @(#)OrderServiceImpl.java, 2020/2/23.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.order.annotation.FlowLimit;
import com.netease.order.dao.OrderDao;
import com.netease.order.po.OrderPO;
import com.netease.order.service.OrderService;

/**
 * @Title: OrderServiceImpl
 * @Package com.netease.order.service
 * @Description:
 * @Author pengy
 * @Date 2020/2/23 8:00
 * @Version v1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void createOrder(String phone) {

    }

    @Override
    public void insert(OrderPO orderPO) {
        orderDao.insert(orderPO);
    }
}
/**
 * @(#)OrderService.java, 2020/2/23.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.service;

import com.netease.order.po.OrderPO;

/**
 * @Title: OrderService
 * @Package com.netease.order.service
 * @Description:
 * @Author pengy
 * @Date 2020/2/23 8:00
 * @Version v1.0
 */
public interface OrderService {

    void createOrder(String phone);

    void insert(OrderPO orderPO);

}
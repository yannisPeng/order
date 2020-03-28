/**
 * @(#)KeFuFlowFrameDao.java, 2018年10月25日.
 * Copyright 2018 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.dao;

import org.springframework.stereotype.Repository;
import com.netease.order.po.OrderPO;


/**
 * 数据库访问对象
 * @author pengyu
 */
public interface OrderDao {

    /**
     * 插入
     */
    void insert(OrderPO orderPO);
}

/**
 * @(#)OrderPO.java, 2020/2/8.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.po;

import java.math.BigDecimal;

/**
 * @Title: OrderPO
 * @Package com.netease.order.po
 * @Description:
 * @Author pengy
 * @Date 2020/2/8 19:40
 * @Version v1.0
 */
public class OrderPO {

    private long id;

    private String orderId;

    private long userId;

    private BigDecimal totalAmount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
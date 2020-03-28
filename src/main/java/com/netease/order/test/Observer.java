/**
 * @(#)Observer.java, 2020/2/17.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.test;


/**
 * @Title: Observer
 * @Package com.netease.order.test
 * @Description:
 * @Author pengy
 * @Date 2020/2/17 10:31
 * @Version v1.0
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();

}
/**
 * @(#)AObserver.java, 2020/2/17.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.test;


/**
 * @Title: AObserver
 * @Package com.netease.order.test
 * @Description:
 * @Author pengy
 * @Date 2020/2/17 10:32
 * @Version v1.0
 */
public class AObserver extends Observer {

    public AObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("A copy that");
    }

}
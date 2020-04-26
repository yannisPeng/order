/**
 * @(#)DirectReceiver.java, 2020/4/26.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Title: DirectReceiver
 * @Package com.netease.order.listener
 * @Description:
 * @Author pengy
 * @Date 2020/4/26 16:36
 * @Version v1.0
 */
@Component
@RabbitListener(queues = "testQueueTest")
public class DirectReceiver {

    @RabbitHandler
    public void process(String testMessage) {
        System.out
            .println("DirectReceiver消费者收到消息  : " + testMessage);
    }

}

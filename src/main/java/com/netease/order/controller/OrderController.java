/**
 * @(#)SecKillController.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 彭羽(pengyu@corp.netease.com)
 */
@RequestMapping("/xhr/order")
@RestController
public class OrderController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 库存回滚，如果下单失败或者付款失败就推送消息告知回滚库存
     */
    @RequestMapping("/rollBackStock")
    public String rollBackStock(
        @RequestParam(value = "skuId", required = true) long skuId) {

        kafkaTemplate.send("order-cancel",
            String.valueOf(skuId) + "-" + UUID.randomUUID());

        return "success";
    }

}

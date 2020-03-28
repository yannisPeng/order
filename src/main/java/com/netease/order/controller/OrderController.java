/**
 * @(#)SecKillController.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netease.order.annotation.FlowLimit;
import com.netease.order.po.CommentInfo;
import com.netease.order.po.OrderPO;
import com.netease.order.service.OrderService;

/**
 * @author 彭羽(pengyu@corp.netease.com)
 */
@RequestMapping("/xhr/order")
@RestController
public class OrderController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private DefaultRedisScript<Boolean> redisScript;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private OrderService orderService;

    /**
     * 下单
     */
    @RequestMapping("/insertOrder")
    public String insertOrder( @RequestBody OrderPO orderPO) {
        orderService.insert(orderPO);
        return "success";
    }

    /**
     * 下单
     */
    @RequestMapping("/createOrder")
    @FlowLimit(callTime = 10)
    public String createOrder( @RequestBody Map<String,Object> params) {
        orderService.createOrder(String.valueOf( params.get("phone")));
        return "success";
    }

    public static void main(String[] args) {
        System.out.println((System.nanoTime() + ""));
        System.out
            .println((System.nanoTime() + "" + new Random().nextInt(9) + ""));
    }

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

    /**
     * 点赞
     */
    @RequestMapping("/like")
    public String like(
        @RequestParam(value = "talkId", required = true) String talkId,
        @RequestParam(value = "commentId", required = true) String commentId,
        @RequestParam(value = "userId", required = true) String userId) {
        String key = "HT" + String.valueOf(talkId);
        System.out.println(redisTemplate.opsForZSet().score(key, commentId));
        Boolean flag = redisTemplate.opsForHash().putIfAbsent("HT" + commentId,
            userId, String.valueOf(1));
        if (!flag) {
            return "已经点过赞";
        }
        Double result = redisTemplate.opsForZSet().incrementScore(key,
            commentId, 1);
        return String.valueOf(result);
    }

    /**
     * 取消点赞
     */
    @RequestMapping("/unlike")
    public String unlike(
        @RequestParam(value = "talkId", required = true) String talkId,
        @RequestParam(value = "commentId", required = true) String commentId,
        @RequestParam(value = "userId", required = true) String userId) {
        String resKey = "HT" + String.valueOf(talkId);
        System.out.println(redisTemplate.opsForZSet().score(resKey, commentId));
        List<String> keys = Arrays.asList("HT" + String.valueOf(commentId),
            String.valueOf("userId"));
        Boolean execute = stringRedisTemplate.execute(redisScript, keys, "");
        if (!execute) {
            return "请先点赞";
        }
        Double result = redisTemplate.opsForZSet().incrementScore(resKey,
            commentId, -1);
        return String.valueOf(result);
    }

    /**
     * 获取评论信息
     */
    @RequestMapping("/getCommentInfo")
    public Map getCommentInfo(
        @RequestParam(value = "talkId", required = true) String talkId) {
        CommentInfo info1 = new CommentInfo();
        info1.setId(1);
        info1.setText("评论1");
        CommentInfo info2 = new CommentInfo();
        info2.setId(2);
        info2.setText("评论2");
        CommentInfo info3 = new CommentInfo();
        info3.setId(3);
        info3.setText("评论3");
        CommentInfo info4 = new CommentInfo();
        info4.setId(4);
        info4.setText("评论4");
        CommentInfo info5 = new CommentInfo();
        info5.setId(5);
        info5.setText("评论5");
        List<CommentInfo> infos = new ArrayList<>();
        infos.add(info1);
        infos.add(info2);
        infos.add(info3);
        infos.add(info4);
        infos.add(info5);
        return appendLikeNum(infos, talkId);
    }

    private Map appendLikeNum(List<CommentInfo> infos, String talkId) {
        //组装评论id和点赞数维度的map
        Map<String, CommentInfo> maps = new HashMap<>();
        for (CommentInfo info: infos) {
            maps.put(String.valueOf(info.getId()), null);
        }
        Set<ZSetOperations.TypedTuple<String>> tupleSet = redisTemplate
            .opsForZSet().rangeWithScores("HT" + talkId, 0, -1);
        Iterator<ZSetOperations.TypedTuple<String>> iterator = tupleSet
            .iterator();
        while (iterator.hasNext()) {
            ZSetOperations.TypedTuple<String> next = iterator.next();
            if (maps.containsKey(next.getValue())) {
                CommentInfo info = new CommentInfo();
                info.setId(Long.parseLong(next.getValue()));
                info.setLikeNum(next.getScore().intValue());
                maps.put(next.getValue(), info);
            }
        }
        return maps;
    }

    /**
     * 游标测试
     */
    @RequestMapping("/testRedisScan")
    public String testRedisScan() {
        for (int i = 1; i < 1000000; i++) {
            String x = String.valueOf(i);
            redisTemplate.opsForValue().set("MN" + x, String.valueOf(i));
        }
        return "success";
    }

}

/**
 * @(#)LimitAspect.java, 2020/2/22.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.aspect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.netease.order.annotation.FlowLimit;

/**
 * @Title: LimitAspect
 * @Package com.netease.order.aspect
 * @Description:
 * @Author pengy
 * @Date 2020/2/22 21:44
 * @Version v1.0
 */
@Component
@Aspect
@Order(value = 0)
public class LimitAspect {

    @Autowired
    private RedisTemplate redisTemplate;

    @Pointcut("execution(* com.netease.order.controller.*.*(..)) && args(maps)")
    public void cutMethod(Map<String,Object> maps) {

    }

    @Around("cutMethod(maps)")
    public Object dealLimit(ProceedingJoinPoint joinPoint,Map maps) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String phone = maps.get("phone").toString();
        Object haveCallTime = redisTemplate.opsForValue().get(phone);
        Integer call = 0;
        if(haveCallTime != null){
            call = Integer.valueOf(haveCallTime.toString());
        }else{
            redisTemplate.opsForValue().set(phone,"0");
            redisTemplate.expire(phone,100, TimeUnit.MINUTES);
        }
        FlowLimit flowLimit = method.getAnnotation(FlowLimit.class);
        int callTime = flowLimit.callTime();
        if (callTime < call) {
            return "接口次数限制";
        } else {
            try {
                redisTemplate.opsForValue().increment(phone);
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return "success aspect";
    }
}

package com.netease.order.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title: FlowLimit
 * @Package com.netease.seckill
 * @Description:
 * @Author pengy
 * @Date 2020/2/22 21:13
 * @Version v1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FlowLimit {

    int callTime() default 100;

}

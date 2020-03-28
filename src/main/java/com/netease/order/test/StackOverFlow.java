/**
 * @(#)StackOverFlow.java, 2020/3/9.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.test;

/**
 * @Title: StackOverFlow
 * @Package com.netease.order.test
 * @Description:
 * @Author pengy
 * @Date 2020/3/9 10:05
 * @Version v1.0
 */
public class StackOverFlow {

    private static int count = 0;

    public static void main(String[] args) {
        try {
            test(1);
        } catch (Error e) {
            System.out.println(count);
        }
    }

    private static void test(int i) {
        if (i < 0) {
            return;
        }
        count++;
        test(1);
    }

}

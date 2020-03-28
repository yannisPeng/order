/**
 * @(#)RealShopping.java, 2020/2/17.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.test;

/**
 * @Title: RealShopping
 * @Package com.netease.order.test
 * @Description:
 * @Author pengy
 * @Date 2020/2/17 10:43
 * @Version v1.0
 */
public class ProxyShopping implements Shopping {

    RealShopping realShopping;

    @Override
    public void goShopping() {
        if(realShopping == null){
            realShopping = new RealShopping();
        }
        System.out.println("hava money");
        realShopping.goShopping();
    }

}
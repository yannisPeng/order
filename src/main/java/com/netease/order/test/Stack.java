/**
 * @(#)Stack.java, 2020/4/9.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.test;

import java.util.Arrays;

/**
 * @Title: Stack
 * @Package com.netease.order.test
 * @Description:
 * @Author pengy
 * @Date 2020/4/9 8:52
 * @Version v1.0
 */
public class Stack<E> {

    private E[] elements;

    private int cursor = 0;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[])DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.elements = (E[])new Object[size];
    }

    public void push(E e){
        ensureCapacity();
        elements[cursor] = e;
        cursor ++;
    }

    private void ensureCapacity() {

    }

    @Override
    public String toString() {
        return "Stack{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
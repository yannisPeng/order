/**
 * @(#)Subject.java, 2020/2/17.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Subject
 * @Package com.netease.order.test
 * @Description:
 * @Author pengy
 * @Date 2020/2/17 10:33
 * @Version v1.0
 */
public class Subject {

    private List<Observer> allObservers = new ArrayList<>();

    private int state;

    public void attach(Observer observer){
        allObservers.add(observer);
    }

    public void notifyAllObservers(){
        for(Observer observer : allObservers){
            observer.update();
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
}
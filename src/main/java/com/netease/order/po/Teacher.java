/**
 * @(#)Teacher.java, 2019/10/30.
 * <p/>
 * Copyright 2019 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @Title: Teacher
 * @Package com.netease.order.po
 * @Description: ${Description}
 * @Author pengy
 * @Date 2019/10/30 9:40
 * @Version v1.0
 */
public class Teacher implements Serializable {

    private static final long serialVersionUID = 8944716339649886554L;

    private String name;

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
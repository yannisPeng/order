/**
 * @(#)Teacher.java, 2019/10/30.
 * <p/>
 * Copyright 2019 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.po;

import lombok.Data;

/**
 * @Title: Teacher
 * @Package com.netease.order.po
 * @Description: ${Description}
 * @Author pengy
 * @Date 2019/10/30 9:40
 * @Version v1.0
 */
@Data
public class Teacher extends BaseEntiry {

    private String name;

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }
}
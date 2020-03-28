/**
 * @(#)Student.java, 2019/10/30.
 * <p/>
 * Copyright 2019 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.po;

import lombok.Data;

/**
 * @Title: Student
 * @Package com.netease.order.po
 * @Description: ${Description}
 * @Author pengy
 * @Date 2019/10/30 9:40
 * @Version v1.0
 */
@Data
public class Student extends BaseEntiry {

    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
}
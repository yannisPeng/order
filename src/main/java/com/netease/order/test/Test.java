/**
 * @(#)Test.java, 2019/10/29.
 * <p/>
 * Copyright 2019 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.plaf.synth.SynthTextAreaUI;

import com.netease.order.po.BaseEntiry;
import com.netease.order.po.Student;
import com.netease.order.po.Teacher;

/**
 * @Title: Test
 * @Package com.netease.order.test
 * @Description: ${Description}
 * @Author pengy
 * @Date 2019/10/29 9:33
 * @Version v1.0
 */
public class Test {


    private AtomicInteger atomicInteger = new AtomicInteger(10);

    public int add(){
        return atomicInteger.addAndGet(1);
    }

    public static void main(String[] args) {

        Student student = new Student();
        student.setName("张三");
        Optional<String> optional = Optional.ofNullable(student.getName());
        if(optional.isPresent()){
            System.out.println("存在");
        }
        String name = optional.get();
        System.out.println(name);

    }

}
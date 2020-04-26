/**
 * @(#)Test.java, 2019/10/29.
 * <p/>
 * Copyright 2019 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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

    public static void main(String[] args) throws ParseException {
        Stack<String> stack = new Stack();
        stack.push("1");
        System.out.println(stack.toString());
    }

    public static boolean valid(Collection<? extends String> col) {
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == null) {
                return true;
            }
        }
        return false;
    }

}

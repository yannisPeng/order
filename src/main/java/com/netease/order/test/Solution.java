/**
 * @(#)Solution.java, 2020/2/12.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.test;

import java.util.List;

import org.checkerframework.checker.units.qual.A;

/**
 * @Title: Solution
 * @Package com.netease.order.test
 * @Description:
 * @Author pengy
 * @Date 2020/2/12 14:22
 * @Version v1.0
 */
public class Solution {

    public static void sortIntegers2(int[] A, int begin, int end) {
        // write your code here
        if (end <= 0 || begin >= A.length - 1) {
            return;
        }
        int temp = A[begin];
        boolean flag = true;
        while (begin != end) {
            //判断从左还是从右
            if (flag) {
                if (A[end] < temp) {
                    A[begin] = A[end];
                    begin++;
                } else {
                    end--;
                    continue;
                }
                flag = false;
                continue;
            }
            if (!flag) {
                if (A[begin] >= temp) {
                    A[end] = A[begin];
                    end--;
                } else {
                    begin++;
                    continue;
                }
                flag = true;
                continue;
            }
        }
        A[begin] = temp;
        //左边
        sortIntegers2(A, 0, begin - 1);
        //右边
        sortIntegers2(A, 6, A.length - 1);
        System.out.println(A.toString());
    }

    public static void main(String[] args) {
        sortIntegers2(new int[] { 7, 2, 3, 1, 5, 9, 8, 4 }, 0, 7);
    }

}

/**
 * @(#)TreeNode.java, 2020/2/15.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.test;

/**
 * @Title: TreeNode
 * @Package com.netease.order.test
 * @Description:
 * @Author pengy
 * @Date 2020/2/15 11:30
 * @Version v1.0
 */
public class TreeNode {

    public int val;

    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

}

/**
 * @(#)CommentInfo.java, 2020/1/28.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.po;

/**
 * @Title: CommentInfo
 * @Package com.netease.order.po
 * @Description:
 * @Author pengy
 * @Date 2020/1/28 10:08
 * @Version v1.0
 */
public class CommentInfo {

    private long id;

    private String text;

    /**
     * 点赞数
     */
    private int likeNum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }
}
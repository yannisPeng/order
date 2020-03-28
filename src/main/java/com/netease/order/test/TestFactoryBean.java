/**
 * @(#)TestFactoryBean.java, 2020/2/26.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.test;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Title: TestFactoryBean
 * @Package com.netease.order.test
 * @Description:
 * @Author pengy
 * @Date 2020/2/26 10:28
 * @Version v1.0
 */
public class TestFactoryBean implements FactoryBean, InitializingBean {

    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
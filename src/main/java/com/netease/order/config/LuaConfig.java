/**
 * @(#)LuaConfig.java, 2020/1/28.
 * <p/>
 * Copyright 2020 Woof, Inc. All rights reserved.
 * WOOF PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

/**
 * @Title: LuaConfig
 * @Package com.netease.order.config
 * @Description:
 * @Author pengy
 * @Date 2020/1/28 9:18
 * @Version v1.0
 */
@Configuration
public class LuaConfig {

    @Bean
    public DefaultRedisScript<Boolean> redisScript() {
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("script/unlike.lua")));
        redisScript.setResultType(Boolean.class);
        return redisScript;
    }

    public String getClassName(){
        return "LuaConfig";
    }

}
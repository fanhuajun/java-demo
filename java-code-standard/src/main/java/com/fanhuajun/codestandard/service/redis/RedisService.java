/*
 * @(#)RedisService.java 2018年3月22日
 * 
 * Copyright (c), 2018 万科物业发展有限公司
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.codestandard.service.redis;

import redis.clients.jedis.Jedis;

/**
 *
 * @author fanhuajun
 * @date 2018年3月22日 下午2:36:10
 * @version V1.0.0 @description：
 * 
 */
public class RedisService {

    @SuppressWarnings("resource")
    public static void redis() {
        // 连接本地的 Redis 服务

        // https://github.com/MicrosoftArchive/redis/releases 下载Redis本地安装
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("连接成功");
        // 查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());

        // 设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");

    }

    public static void main(String[] args) {
        redis();
    }

}

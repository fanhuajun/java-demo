/*
 * @(#)annotation.java 2017年6月25日
 * 
 * Copyright (c), 2016 深圳市万睿智能科技有限公司（Shenzhen Wan Rui Intelligent Technology Co., Ltd.）
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.web;

import org.junit.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author fanhuajun
 * @date 2017年6月25日 上午1:00:38
 * @version V1.0.0
 * description：
 * 
 */
@Configuration
public class Annotation12 {
    
    
    private int iiii = 1214;
    
    @Test
    public static void test(String[] args) {
        System.out.println("nihao");
    }
    
    
    @Bean
    public Student getStudent(){
        return new Student();
    }

}

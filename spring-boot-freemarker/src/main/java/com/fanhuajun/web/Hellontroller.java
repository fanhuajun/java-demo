/*
 * @(#)Hello.java 2017年7月8日
 * 
 * Copyright (c), 2016 深圳市万睿智能科技有限公司（Shenzhen Wan Rui Intelligent Technology Co., Ltd.）
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fanhuajun
 * @date 2017年7月8日 上午11:08:12
 * @version V1.0.0
 * description：
 * 
 */
@Controller
public class Hellontroller {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping("/hello")
    public String hello(@RequestHeader("User-Agent") String UserAgent){
        //6d1e6007.ngrok.io/hello
        
        logger.info("user-Agent={}", UserAgent);
        
        return "hello";
    }

}



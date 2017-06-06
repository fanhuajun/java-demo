/*
 * @(#)Hello.java 2017年6月6日
 * 
 * Copyright (c), 2016 深圳市万睿智能科技有限公司（Shenzhen Wan Rui Intelligent Technology Co., Ltd.）
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fanhuajun
 * @date 2017年6月6日 上午10:26:56
 * @version V1.0.0
 * description：
 * 
 */
@RestController
public class Hello {
    
    @RequestMapping("/hello")
    public String hello(){
        return "hello world fanhuajun";
    }
}

/*
 * @(#)GreetingController.java 2017年6月24日
 * 
 * Copyright (c), 2016 深圳市万睿智能科技有限公司（Shenzhen Wan Rui Intelligent Technology Co., Ltd.）
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author fanhuajun
 * @date 2017年6月24日 下午3:15:21
 * @version V1.0.0
 * description：
 * 
 */
@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}











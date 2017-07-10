/*
 * @(#)IpInfoControler.java 2017年7月8日
 * 
 * Copyright (c), 2016 深圳市万睿智能科技有限公司（Shenzhen Wan Rui Intelligent Technology Co., Ltd.）
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fanhuajun.web.dto.IpInfo;

/**
 *
 * @author fanhuajun
 * @date 2017年7月8日 下午12:18:35
 * @version V1.0.0
 * description：
 * 
 */
@Controller
public class IpInfoControler {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @ResponseBody
    @RequestMapping(value = "/ipInfo", method = RequestMethod.POST)
    public String getIp(@RequestBody IpInfo IpInfo){
        
        logger.info("ipInfo={}", IpInfo.getIp());
        return "s";
    }
}




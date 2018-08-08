/*
 * @(#)Test.java 2018年2月5日
 * 
 * Copyright (c), 2018 万科物业发展有限公司
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.codestandard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author fanhuajun
 * @date 2018年2月5日 下午2:45:07
 * @version V1.0.0 @description：
 * 
 */
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
//    @Autowired private DataSource dataSource;
    
    @RequestMapping(value = "/getUser") // http://localhost:8080/getUser
    @ResponseBody
    public void inserUser() {
        logger.info("inserUser");
    }

}
                                                      
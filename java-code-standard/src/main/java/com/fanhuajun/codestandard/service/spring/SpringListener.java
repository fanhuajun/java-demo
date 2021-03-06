/*
 * @(#)SpringListener.java 2018年4月22日
 * 
 * Copyright (c), 2018 万科物业发展有限公司
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.codestandard.service.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 *
 * @author fanhuajun
 * @date 2018年4月22日 下午11:30:05
 * @version V1.0.0
 * @description：
 * 
 */
public class SpringListener implements ApplicationListener<SpringApplicationEvent> {

    private static final Logger logger = LoggerFactory.getLogger(SpringListener.class);
    
    @Override
    public void onApplicationEvent(SpringApplicationEvent event) {
        
        logger.info("事件={}", event.getSource());
    }

}

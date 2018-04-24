/*
 * @(#)Spring.java 2018年4月22日
 * 
 * Copyright (c), 2018 万科物业发展有限公司
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.codestandard.service.spring;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author fanhuajun
 * @date 2018年4月22日 下午10:31:20
 * @version V1.0.0
 * @description：
 * 
 */
public class SpringInit implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // TODO Auto-generated method stub
        System.out.println("sdfdfd樊华军");
    }

}

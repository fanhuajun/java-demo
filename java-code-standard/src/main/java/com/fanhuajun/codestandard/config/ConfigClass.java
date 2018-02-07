/*
 * @(#)ConfigClass.java 2018年2月5日
 * 
 * Copyright (c), 2018 万科物业发展有限公司
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.codestandard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 *
 * @author fanhuajun
 * @date 2018年2月5日 下午2:57:35
 * @version V1.0.0
 * @description：
 * 
 */
@Configuration
@ImportResource(locations={"classpath:application_context_dependence.xml"})
public class ConfigClass {

}

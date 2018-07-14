/*
 * @(#)ConfigClass.java 2018年2月5日
 * 
 * Copyright (c), 2018 万科物业发展有限公司
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.codestandard.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.zookeeper.ZooKeeper;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.fanhuajun.codestandard.service.zookeeper.AppWatcher;

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

//	@Bean
	public ZooKeeper zooKeeperBean () {
		ZooKeeper zooKeeper = null;
		try {
			zooKeeper = new ZooKeeper("10.0.74.128:2181", 5000, new AppWatcher());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zooKeeper;
	}
	
//	@Bean
//	@ConfigurationProperties("app.datasource")
	public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	}
}

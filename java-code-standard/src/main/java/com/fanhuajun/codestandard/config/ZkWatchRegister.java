package com.fanhuajun.codestandard.config;

import java.io.IOException;

import org.apache.zookeeper.ZooKeeper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fanhuajun.codestandard.service.zookeeper.AppWatcher2;

@Configuration
public class ZkWatchRegister {
	
	@Bean
	public ZooKeeper AppWatcher2 () {
		ZooKeeper zooKeeper = null;
		try {
			zooKeeper = new ZooKeeper("10.0.74.128:2181", 5000, new AppWatcher2());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zooKeeper;
		
	}

}

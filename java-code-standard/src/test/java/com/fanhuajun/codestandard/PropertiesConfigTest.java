package com.fanhuajun.codestandard;

import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fanhuajun.codestandard.config.PropertiesConfig;


public class PropertiesConfigTest extends TestBase {

	@Autowired PropertiesConfig PropertiesConfig;
	
	@Autowired ZooKeeper zooKeeper;
	
	
	@Test
	public void test() {

		logger.info("PropertiesConfig={}", PropertiesConfig);
	}

}

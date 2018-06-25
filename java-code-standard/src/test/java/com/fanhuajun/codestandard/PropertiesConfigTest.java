package com.fanhuajun.codestandard;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fanhuajun.codestandard.config.PropertiesConfig;


public class PropertiesConfigTest extends TestBase {

	@Autowired
	PropertiesConfig PropertiesConfig;
	
	
	@Test
	public void test() {

		logger.info("PropertiesConfig={}", PropertiesConfig);
	}

}

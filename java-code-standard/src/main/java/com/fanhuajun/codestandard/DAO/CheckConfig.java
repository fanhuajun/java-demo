package com.fanhuajun.codestandard.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fanhuajun.codestandard.controller.UserController;

@Repository
public class CheckConfig {
	
private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
//	@Autowired private DataSource dataSource;
	
	public CheckConfig() {
		
		logger.info("--dataSource--={}");
	}
	
}

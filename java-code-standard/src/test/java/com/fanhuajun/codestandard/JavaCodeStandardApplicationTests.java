package com.fanhuajun.codestandard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fanhuajun.codestandard.controller.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaCodeStandardApplicationTests {
    
    @Autowired
    UserController UserController;

	@Test
	public void contextLoads() {
	    
	    UserController.inserUser();
	}

}

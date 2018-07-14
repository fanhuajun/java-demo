package com.fanhuajun.codestandard.reflect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fanhuajun.codestandard.reflect.Proxy.HelloController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {
	
	@Autowired HelloController helloController;
	
	@Test
	public void testHelloService() {
		helloController.sayHello();
	}

}

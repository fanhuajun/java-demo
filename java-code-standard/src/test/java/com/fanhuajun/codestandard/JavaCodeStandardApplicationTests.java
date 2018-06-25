package com.fanhuajun.codestandard;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fanhuajun.codestandard.controller.UserController;
import com.fanhuajun.codestandard.service.UserService;
import com.fanhuajun.codestandard.service.UserServiceImpl;
import com.fanhuajun.codestandard.service.async.AsyncTaskService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JavaCodeStandardApplicationTests {

	@Autowired
	UserController UserController;

	@Autowired
	AsyncTaskService asyncTaskService;

	@Test
	public void contextLoads() {

		UserController.inserUser();
	}

	@Test
	public void asyncTest() {

		int loopNum = 9;

		CountDownLatch latch = new CountDownLatch(loopNum);

		for (int i = 0; i < 9; i++) {
			asyncTaskService.executeAsyncTask1(i);
			asyncTaskService.executeAsyncTask2(i);
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
//		 userService instanceof UserServiceImpl
		// UserService.class.isAssignableFrom(UserServiceImpl.class)
		
		UserService.class.isAssignableFrom(UserServiceImpl.class);
		
		if (UserService.class.isAssignableFrom(UserServiceImpl.class)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
	}


}

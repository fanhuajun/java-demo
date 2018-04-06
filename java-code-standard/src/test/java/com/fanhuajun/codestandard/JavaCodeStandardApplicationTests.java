package com.fanhuajun.codestandard;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fanhuajun.codestandard.controller.UserController;
import com.fanhuajun.codestandard.service.async.AsyncTaskService;

@RunWith(SpringRunner.class)
@SpringBootTest
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
	public void asyncTest () {
	    
	    int loopNum = 9;
	    
	    CountDownLatch latch = new CountDownLatch(loopNum);
	    
	    for(int i=0; i< 9; i++){
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

}

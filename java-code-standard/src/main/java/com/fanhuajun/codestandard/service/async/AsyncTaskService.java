package com.fanhuajun.codestandard.service.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fanhuajun.codestandard.controller.UserController;

@Service
public class AsyncTaskService {
	
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
	/**
     * 线程实例
     * @param i
     */
	@Async
    public void executeAsyncTask1(int i){
		Thread th = Thread.currentThread();
		logger.info("执行异步任务(1):"+i);
		logger.info("线程标识(1)："+th.getId());
        
    }
	
    /**
     * 线程实例
     * @param i
     */
    @Async
    public void executeAsyncTask2(int i){
    	Thread th = Thread.currentThread();
    	logger.info("执行异步任务(2):" + i);
		logger.info("线程标识(2)：" + th.getId());
    }

}

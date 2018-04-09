/*
 * @(#)AsyncTaskExecutorConfig.java 2018年4月3日
 * 
 * Copyright (c), 2018 万科物业发展有限公司
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.codestandard.service.async;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 *
 * @author fanhuajun
 * @date 2018年4月3日 上午9:46:56
 * @version V1.0.0 @description：
 * 
 */
@Service
@EnableAsync
public class AsyncTaskExecutorConfig implements AsyncConfigurer {

    /**
     * 注入一个线程池 设置线程池属性
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(40);
        taskExecutor.setMaxPoolSize(50); // 线程大小
        taskExecutor.setQueueCapacity(1024);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

}

/*
 * @(#)ControllerAOP.java 2018年2月5日
 * 
 * Copyright (c), 2018 万科物业发展有限公司
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.codestandard.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fanhuajun.codestandard.controller.UserController;

/**
 *
 * @author fanhuajun
 * @date 2018年2月5日 下午2:44:42
 * @version V1.0.0 @description：
 * 
 */
@Component
@Aspect
public class ControllerAOP {
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    // https://blog.csdn.net/tianjun2012/article/details/47809739
    @Around(value="execution(public void inserUser(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {

        long startTime = System.currentTimeMillis();

        try {
            logger.info("进入aop：{}", startTime);
            
            //目标方法
            pjp.proceed();
            
            long endTime = System.currentTimeMillis();
            logger.info("结束aop：{}", endTime);
            // logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {

        }

        return null;
    }

}

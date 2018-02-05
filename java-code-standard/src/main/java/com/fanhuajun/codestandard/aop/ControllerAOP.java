/*
 * @(#)ControllerAOP.java 2018年2月5日
 * 
 * Copyright (c), 2018 万科物业发展有限公司
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.codestandard.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fanhuajun
 * @date 2018年2月5日 下午2:44:42
 * @version V1.0.0
 * @description：
 * 
 */
@Controller
public class ControllerAOP {
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        
        
        long startTime = System.currentTimeMillis();


        try {
          pjp.proceed();
          System.out.println("进入aop："+startTime);
//          logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            
        }

        return null;
      }

}

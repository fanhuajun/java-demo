package com.fanhuajun.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private WebApplicationContext wac;
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    GreetingController greetingController;
    
    /*@Autowired
    Annotation12 annotation12;*/
    
    @Autowired
    Student student;

    @Test
    public void contextLoads() {

        System.out.println("nhao");
    }

}

package com.fanhuajun.codestandard.reflect.Proxy;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImplV1 implements HelloService{
     public void sayHello(){
          System.out.println("------------- Hello from V1 -------------");
     }
     public void sayHi(){
          System.out.println("Hi from V1");
     }
}


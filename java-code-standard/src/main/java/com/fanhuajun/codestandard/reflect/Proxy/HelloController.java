package com.fanhuajun.codestandard.reflect.Proxy;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
	
	@RoutingInjected
    private HelloService helloService;
    
    public void sayHello(){
        this.helloService.sayHello();
    }

    public void sayHi(){
        this.helloService.sayHi();
    }


}

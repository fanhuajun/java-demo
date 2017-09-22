package com.fanhuajun.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerException;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
public class SpringCloudStarterEurekaClient_1 {

    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }
    
    @RequestMapping("/info")
    public String info(){
    	return "Hello world info";
    }

    public static void main(String[] args) {
    	
        new SpringApplicationBuilder(SpringCloudStarterEurekaClient_1.class).web(true).run(args);
    }

}

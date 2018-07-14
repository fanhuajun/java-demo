package com.fanhuajun.codestandard.reflect.Proxy;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImplV2 implements HelloService {
	public void sayHello() {
		System.out.println("------------- Hello from V2 -------------");
	}

	public void sayHi() {
		System.out.println("Hi from V2");
	}
}

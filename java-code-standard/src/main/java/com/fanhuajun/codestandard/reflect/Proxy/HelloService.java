package com.fanhuajun.codestandard.reflect.Proxy;

public interface HelloService{

    @RoutingSwitch("A")
    void sayHello();

    void sayHi();
}

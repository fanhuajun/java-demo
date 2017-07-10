package com.github.binarywang.demo.wechat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.binarywang.demo.wechat.mapper.CityMapper;
import com.github.binarywang.demo.wechat.mapper.InfoMapper;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@SpringBootApplication
public class WxMpDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WxMpDemoApplication.class, args);
    }

    final private CityMapper cityMapper;
    final private InfoMapper infoMapper;

    public WxMpDemoApplication(CityMapper cityMapper, InfoMapper infoMapper) {
        this.cityMapper = cityMapper;
        this.infoMapper = infoMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.cityMapper.findByState("CA"));
        System.out.println(this.infoMapper.findByState("地址"));
    }
}

/*
 * @(#)NameEnum.java 2017年7月9日
 * 
 * Copyright (c), 2016 深圳市万睿智能科技有限公司（Shenzhen Wan Rui Intelligent Technology Co., Ltd.）
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.github.binarywang.demo.wechat.constant;

/**
 *
 * @author fanhuajun
 * @date 2017年7月9日 下午9:12:09
 * @version V1.0.0
 * description：
 * 
 */
public enum NameEnum {
    
    INFO_FANHUAJUN("樊华军", "o48PpwDDICjLZzrkAxH4hZhykbKE");
    
    
    NameEnum(String name, String openId) {
        // TODO Auto-generated constructor stub
        this.name = name;
        this.openId = openId;
    }
    
    
    private String name;
    
    private String openId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
    

}

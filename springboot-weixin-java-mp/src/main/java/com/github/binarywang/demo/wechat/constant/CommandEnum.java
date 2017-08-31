/*
 * @(#)CommandEnum.java 2017年7月31日
 * 
 * Copyright (c), 2016 深圳市万睿智能科技有限公司（Shenzhen Wan Rui Intelligent Technology Co., Ltd.）
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.github.binarywang.demo.wechat.constant;

/**
 *
 * @author fanhuajun
 * @date 2017年7月31日 下午11:03:40
 * @version V1.0.0
 * description：
 * 
 */
public enum CommandEnum {
    
    USER_NAME_ADD(102, "添加用户", "addUser"),
    
    USER_IDCARD_SELECT(105, "获取身份证信息", "getIdCard");
    
    private String commandName;
    
    private String commandCode;
    
    private int number;
    
    CommandEnum(int number, String commandName, String commandCode) {
        // TODO Auto-generated constructor stub
        this.commandName = commandName;
        this.commandCode = commandCode;
        this.number = number;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCommandCode() {
        return commandCode;
    }

    public void setCommandCode(String commandCode) {
        this.commandCode = commandCode;
    }
    
    

}

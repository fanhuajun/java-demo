/*
 * @(#)UserDO.java 2017年7月13日
 * 
 * Copyright (c), 2016 深圳市万睿智能科技有限公司（Shenzhen Wan Rui Intelligent Technology Co., Ltd.）
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.github.binarywang.demo.wechat.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author fanhuajun
 * @date 2017年7月13日 上午1:13:04
 * @version V1.0.0
 * description：
 * 
 */
public class UserDO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6788293813570785892L;
    
    public Integer uId;
    
    public String userName;
    
    public String openId;
    
    public Date createTime;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    @Override
    public String toString(){
        return uId + userName + createTime;
    }

}

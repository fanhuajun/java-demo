/*
 * @(#)Info.java 2017年7月10日
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
 * @date 2017年7月10日 下午10:30:20
 * @version V1.0.0
 * description：
 * 
 */
public class InfoDO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6392720290828669008L;
    
    private Integer info_id;
    
    private Integer u_id;
    
    private String info_detail;
    
    private Date create_time;

    public String getInfo_detail() {
        return info_detail;
    }

    public void setInfo_detail(String info_detail) {
        this.info_detail = info_detail;
    }

    public Integer getInfo_id() {
        return info_id;
    }

    public void setInfo_id(Integer info_id) {
        this.info_id = info_id;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    
    
    

}

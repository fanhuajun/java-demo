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
    
    private Integer infoId;
    
    private Integer uId;
    
    private String infoDetail;
    
    private Date createTime;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getInfoDetail() {
        return infoDetail;
    }

    public void setInfoDetail(String infoDetail) {
        this.infoDetail = infoDetail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    

}

/*
 * @(#)Keyword.java 2017年7月11日
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
 * @date 2017年7月11日 上午12:14:37
 * @version V1.0.0
 * description：
 * 
 */
public class KeywordDO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3174215813934231942L;
    
    private Integer keywordId;
    
    private Integer pId;
    
    private String keywordName;
    
    private Integer infoId;
    
    private Integer uId;
    
    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    private Date createTime;

    public Integer getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Integer keywordId) {
        this.keywordId = keywordId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

/*
 * @(#)IpInfo.java 2017年7月8日
 * 
 * Copyright (c), 2016 深圳市万睿智能科技有限公司（Shenzhen Wan Rui Intelligent Technology Co., Ltd.）
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.web.dto;

import java.io.Serializable;

/**
 *
 * @author fanhuajun
 * @date 2017年7月8日 下午12:30:03
 * @version V1.0.0
 * description：
 * 
 */
public class IpInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5252064269080797253L;
    
    
    private String city;
    
    private String country;
    
    private String hostname;
    
    private String ip;
    
    private String loc;
    
    private String org;
    
    private String region;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}

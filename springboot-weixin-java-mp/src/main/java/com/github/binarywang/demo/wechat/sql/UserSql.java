/*
 * @(#)Keyword.java 2017年7月10日
 * 
 * Copyright (c), 2016 深圳市万睿智能科技有限公司（Shenzhen Wan Rui Intelligent Technology Co., Ltd.）
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.github.binarywang.demo.wechat.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

/**
 *
 * @author fanhuajun
 * @date 2017年7月10日 下午11:16:38
 * @version V1.0.0
 * description：
 * 
 */
public class UserSql {
    private String BaseColum = "uId, userName, openId, createTime";
    private String Usertable = "w_user";
    
    public String selectByOpenId(Map<String, Object> parameters){
        return new SQL() {{
            SELECT(BaseColum);
            FROM(Usertable);
            WHERE("openId = #{openId}");
          }}.toString();
    }

}

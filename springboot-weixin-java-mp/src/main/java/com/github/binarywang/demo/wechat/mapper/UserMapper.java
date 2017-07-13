/*
 * @(#)Keyword.java 2017年7月10日
 * 
 * Copyright (c), 2016 深圳市万睿智能科技有限公司（Shenzhen Wan Rui Intelligent Technology Co., Ltd.）
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.github.binarywang.demo.wechat.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.github.binarywang.demo.wechat.domain.UserDO;
import com.github.binarywang.demo.wechat.sql.UserSql;

/**
 *
 * @author fanhuajun
 * @date 2017年7月10日 下午11:16:38
 * @version V1.0.0
 * description：
 * 
 */
@Mapper
public interface UserMapper {
    
    /**
     * 根据openId查询用户信息
     * @param openId
     * @return
     */
    @SelectProvider (type = UserSql.class, method = "selectByOpenId")
    public UserDO selectByOpenId(@Param ("openId") String openId);

}

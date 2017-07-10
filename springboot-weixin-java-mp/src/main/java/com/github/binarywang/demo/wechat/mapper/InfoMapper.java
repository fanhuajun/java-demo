/*
 * @(#)CityMapper.java 2017年7月10日
 * 
 * Copyright (c), 2016 深圳市万睿智能科技有限公司（Shenzhen Wan Rui Intelligent Technology Co., Ltd.）
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.github.binarywang.demo.wechat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.binarywang.demo.wechat.domain.InfoDO;

/**
 *
 * @author fanhuajun
 * @date 2017年7月10日 上午12:19:32
 * @version V1.0.0
 * description：
 * 
 */
@Mapper
public interface InfoMapper {

    @Select("SELECT * FROM w_info where infoId in("
              +"select infoId from w_keyword " 
              +"where pId in(SELECT keywordId FROM w_keyword where keywordName = #{keywordName}))")
    List<InfoDO> searchChildInfo(@Param("keywordName") String keywordName);
    
    
    @Select("SELECT * FROM w_info where infoId = ("
              +"select infoId from w_keyword " 
              +"where keywordName = #{keywordName})")
    InfoDO searchInfo(@Param("keywordName") String keywordName);
    

}

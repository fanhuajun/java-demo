/*
 * @(#)Keyword.java 2017年7月10日
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

import com.github.binarywang.demo.wechat.domain.KeywordDO;

/**
 *
 * @author fanhuajun
 * @date 2017年7月10日 下午11:16:38
 * @version V1.0.0
 * description：
 * 
 */
@Mapper
public interface KeywordMapper {
    
    @Select("select * from w_keyword "
              +"where pId in(SELECT keywordId FROM w_keyword where keywordName = #{keywordName})")
    public List<KeywordDO>  seletChildKeyword(@Param("keywordName") String keywordName);
    
    
    /**
     * 
     * 权限：根据关键字查询
     * @param keywordName
     * @return
     */
    @Select("SELECT * FROM w_keyword WHERE keywordName = #{keywordName and keywordId in(#{userKeywordId} ")
    public KeywordDO selectByKeywordName(@Param("keywordName") String keywordName, @Param("userKeywordId") String userKeywordId);
    
    /**
     * 主键查询
     * 可查询父节点
     * @param keywordId
     * @return
     */
    @Select("SELECT * FROM w_keyword WHERE keywordId = #{keywordId}")
    public List<KeywordDO> selectByPrimaryKey(@Param("keywordId") String keywordId);
    
    /**
     * 权限：根据用户openId 查询拥有的关键字id
     * @param openId
     * @return
     */
    @Select("SELECT wkey.`keywordId` FROM w_user wser, w_ref_user_keyword refuk, w_keyword wkey "
            + "WHERE refuk.`userId` = wser.`uId` "
            + "AND refuk.`keywordId` = wkey.`keywordId` "
            + "AND wser.`openId` = #{openId}")
    public List<String> selectKeywordIdByUserId(@Param("openId") String openId);
    
    /**
     * 查询同类关键字
     * @param keywordId
     * @return
     */
    @Select("SELECT * FROM w_keyword "
            +"WHERE pId in (select pId from w_keyword where keywordId = #{keywordId}) "
            +"AND keywordId NOT IN(#{keywordId}) "
            + "and keywordId in(#{userKeywordId})")
    public List<KeywordDO> selectOtherSiblingsKeyword(@Param("keywordId") String keywordId, @Param("userKeywordId") String userKeywordId);

}

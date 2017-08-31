/*
 * @(#)UserService.java 2017年7月13日
 * 
 * Copyright (c), 2016 深圳市万睿智能科技有限公司（Shenzhen Wan Rui Intelligent Technology Co., Ltd.）
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.github.binarywang.demo.wechat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.binarywang.demo.wechat.domain.UserDO;
import com.github.binarywang.demo.wechat.mapper.UserMapper;

import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;

/**
 *
 * @author fanhuajun
 * @date 2017年7月13日 下午4:27:20
 * @version V1.0.0 description：
 * 
 */
@Service
public class UserService extends BaseService {

    @Autowired
    private UserMapper userMapper;

    public String checkUser(WxMpXmlMessage wxMpXmlMessage) {
        UserDO userDO = userMapper.selectByOpenId(wxMpXmlMessage.getFromUser());
        String ret = "";
        if (userDO == null) {
            logger.info("该用户不存在 userName={}", wxMpXmlMessage.getFromUser());
            ret = "请发送姓名或昵称给我";
        } else {
            ret = userDO.toString();
        }
        return ret;
    }
    
    public String addUser(WxMpXmlMessage wxMpXmlMessage){
        String ret = "";
        
        return ret;
    }

}

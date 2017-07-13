package com.github.binarywang.demo.wechat.handler;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.binarywang.demo.wechat.builder.TextBuilder;
import com.github.binarywang.demo.wechat.domain.UserDO;
import com.github.binarywang.demo.wechat.mapper.InfoMapper;
import com.github.binarywang.demo.wechat.mapper.KeywordMapper;
import com.github.binarywang.demo.wechat.mapper.UserMapper;
import com.github.binarywang.demo.wechat.utils.JsonUtils;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {
    
    @Autowired
    private InfoMapper infoMapper;
    
    @Autowired
    private KeywordMapper KeywordMapper;
    
    @Autowired
    private UserMapper userMapper;
    
    

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(WxConsts.XML_MSG_EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
        try {
            if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
                    && weixinService.getKefuService().kfOnlineList()
                    .getKfOnlineList().size() > 0) {
                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
                        .fromUser(wxMessage.getToUser())
                        .toUser(wxMessage.getFromUser()).build();
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        
        
        

        //TODO 组装回复消息
        String content = "收到信息内容：" + JsonUtils.toJson(wxMessage);
        content = "";
        
        UserDO userDO = userMapper.selectByOpenId(wxMessage.getFromUser());
        
        content = userDO.toString();
        //查询用户拥有的关键字
       /* List<String> keywordNameList = KeywordMapper.selectKeywordIdByUserId(wxMessage.getFromUser());
        String userKeywordId = "";
        if(!keywordNameList.isEmpty()){
            userKeywordId += "你可以查询的关键字有:\n";
            for(String str : keywordNameList){
                userKeywordId += str+",";
            }
        }*/
        //查询父节点
        /*KeywordDO keywordDO = KeywordMapper.selectByKeywordName(wxMessage.getFromUser(), userKeywordId);
        content = keywordDO.getKeywordName();*/
        /*//查询关键字信息
        InfoDO infoDO = infoMapper.searchInfo(wxMessage.getContent());
        if(infoDO != null && infoDO.getInfoDetail() != null){
            content = infoDO.getInfoDetail();
        } else {
            //查询子关键字信息
            List<InfoDO> infoDOList = infoMapper.searchChildInfo(wxMessage.getContent());
            if(!infoDOList.isEmpty()){
                for(InfoDO info : infoDOList){
                    content = content + info.getInfoDetail()+ "\n";
                }
                List<KeywordDO> keywordDOList = KeywordMapper.seletChildKeyword(wxMessage.getContent());
                
                if(!keywordDOList.isEmpty()){
                    content += "\n你还可以输入 \n";
                    for(KeywordDO keywordDO : keywordDOList){
                        content = content + keywordDO.getKeywordName()+ "\n";
                    }
                }
            }
        }*/

        return new TextBuilder().build(content, wxMessage, weixinService);

    }

}

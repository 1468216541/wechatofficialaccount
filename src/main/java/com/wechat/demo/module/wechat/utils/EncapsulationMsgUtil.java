package com.wechat.demo.module.wechat.utils;

import com.wechat.demo.common.MsgTypeUtil;
import com.wechat.demo.module.wechat.model.NewsMessage;
import com.wechat.demo.module.wechat.model.TextMessage;
/**
 * 回复信息组装
 */
import java.util.Map;

public class EncapsulationMsgUtil {

    /**
     * 组装文本消息
     */
    public static TextMessage returnTextMsg(Map<String,String> map){
        TextMessage textMessage = new TextMessage();
        textMessage.setFromUserName(map.get("toUserName"));
        textMessage.setToUserName(map.get("formUserName"));
        textMessage.setContent(map.get("content"));
        textMessage.setCreateTime(System.currentTimeMillis()/1000);
        textMessage.setMsgType(MsgTypeUtil.RETURN_MSG_TYPE_TEXT);
        return textMessage;
    }

    /**
     * 组装图文消息
     */
    public static NewsMessage returnNewsMsg(Map<String,String> map){
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.setFromUserName(map.get("toUserName"));
        newsMessage.setToUserName(map.get("formUserName"));
        newsMessage.setCreateTime(System.currentTimeMillis()/1000);
        newsMessage.setMsgType(MsgTypeUtil.RETURN_MSG_TYPE_NEWS);
        return newsMessage;
    }

}

package com.wechat.demo.module.wechat.service;

import com.wechat.demo.common.MsgTypeUtil;
import com.wechat.demo.constant.InvariableAttribute;
import com.wechat.demo.module.user.service.impl.UserServiceImpl;
import com.wechat.demo.module.wechat.model.Articles;
import com.wechat.demo.module.wechat.model.NewsMessage;
import com.wechat.demo.module.wechat.model.TextMessage;
import com.wechat.demo.module.wechat.utils.TemplateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProcessingMsg {

    public static String switchMsg(Map<String , Object> map){
        String result = InvariableAttribute.RETURN_SUCCESS;
        String openId = ((TextMessage) map.get("textMessage")).getToUserName();
        switch (map.get("msgType").toString()){
            //文本类型
            case MsgTypeUtil.RETURN_MSG_TYPE_TEXT :
            {
                TextMessage textMessage = (TextMessage) map.get("textMessage");
                String content = textMessage.getContent();
                if ("1".equals(content)){
                    result = "什么1？";
                }else if ("2".equals(content)){
                    NewsMessage newsMessage = (NewsMessage) map.get("newsMessage");
                    newsMessage.setArticleCount(1);
                    Articles articles = new Articles();
                    articles.setDescription("一条测试的图文信息,小熊猫。");
                    articles.setTitle("测试小熊猫");
                    articles.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/1zoe9VENeFbyN5jJJWmd8oFTI9YnGbIq40rLPIc3Am7XqBiaIlfpzQiabwKSlL47bwBFrSZnAdPDBeHiaKwsBZl8A/0?wx_fmt=jpeg");
                    articles.setUrl("http://www.baidu.com");
                    List<Articles> list = new ArrayList<>();
                    list.add(articles);
                    newsMessage.setArticles(list);
                    return MsgTypeUtil.newsMessageToXml(newsMessage);
                }else {
                    result = "公众号未接入自动聊天功能。请及时联系管理员(13759679259)";
                }
                textMessage.setContent(result);
                result = MsgTypeUtil.textMessageToXml(textMessage);
                System.err.println(result);
                return result;
            }
            case MsgTypeUtil.REQUEST_MSG_TYPE_EVENT:
            {
                switch (map.get("event").toString()){
                    //订阅操作
                    case InvariableAttribute.SUBSCRIBE:
                    {
                        System.err.println("订阅");
                        UserServiceImpl userService = (UserServiceImpl) map.get("userService");
                        userService.saveUserInfo(openId);
                        return TemplateUtil.sendSubscribe(openId);
                    }
                    //取消订阅操作
                    case InvariableAttribute.UNSUBSCRIBE:
                    {
                        System.err.println("取消订阅");
                        return result;
                    }
                    //自定义菜单点击事件
                    //获取CLICK事件的key
                    case InvariableAttribute.CLICK:
                    {
                        switch (map.get("eventKey").toString()){
                            default:
                            {
                                System.err.println("默认点击");
                                return result;
                            }
                        }
                    }
                }
            }

        }
        return null;
    }

}

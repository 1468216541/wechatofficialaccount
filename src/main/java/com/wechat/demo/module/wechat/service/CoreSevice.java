package com.wechat.demo.module.wechat.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wechat.demo.common.HttpUtils;
import com.wechat.demo.common.MsgTypeUtil;
import com.wechat.demo.constant.InvariableAttribute;
import com.wechat.demo.module.user.service.impl.UserServiceImpl;
import com.wechat.demo.module.wechat.model.AccessTokenModel;
import com.wechat.demo.module.wechat.model.NewsMessage;
import com.wechat.demo.module.wechat.model.TextMessage;
import com.wechat.demo.module.wechat.utils.EncapsulationMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class CoreSevice {

    private static AccessTokenModel at;

    @Autowired
    UserServiceImpl userService;

    private static void getToken(){
        String accessToken = HttpUtils.doGet(InvariableAttribute.ACCESS_TOKEN_URL,null);
        JSONObject jsonObject = JSON.parseObject(accessToken);
        String token = jsonObject.getString("access_token");
        String exprieIn = jsonObject.getString("expires_in");
        at = new AccessTokenModel(token,exprieIn);
    }
    public static String getAccessToken(){
        if(at == null || at.isExpired()){
            getToken();
        }
        return at.getAccessToken();
    }

    public String pareRequest(HttpServletRequest request) throws Exception {
        String xml = HttpUtils.getJsonData(request);
        System.err.println(xml);
        //使用xml解析将微信服务器发送过来的数据解析成map
        Map<String, String> map = MsgTypeUtil.xmlToMap(xml);
        String toUserName = map.get("ToUserName");//开发者微信号
        String fromUserName = map.get("FromUserName");//发送方帐号（一个OpenID）
        String content = map.get("Content");//文本消息内容
        String msgType = map.get("MsgType");//消息类型
        String event = map.get("Event");//时间推送类型
        String eventKey = map.get("EventKey");//时间推送类型
        Map<String,String> paramMap = new HashMap<String,String>(16);
        if (!StringUtils.isEmpty(fromUserName)){
            paramMap.put("formUserName",fromUserName);
        }
        if (!StringUtils.isEmpty(toUserName)){
            paramMap.put("toUserName",toUserName);
        }
        if (!StringUtils.isEmpty(content)){
            paramMap.put("content",content);
        }
        TextMessage textMessage = EncapsulationMsgUtil.returnTextMsg(paramMap);
        NewsMessage newsMessage = EncapsulationMsgUtil.returnNewsMsg(paramMap);
        Map<String,Object> msgMap = new HashMap<String,Object>(16);
        msgMap.put("textMessage",textMessage);
        msgMap.put("newsMessage",newsMessage);
        if (!StringUtils.isEmpty(msgType)){
            msgMap.put("msgType",msgType);
        }
        if (!StringUtils.isEmpty(event)){
            msgMap.put("event",event);
        }
        if (!StringUtils.isEmpty(eventKey)){
            msgMap.put("eventKey",eventKey);
        }
        msgMap.put("userService",userService);
        return ProcessingMsg.switchMsg(msgMap);
    }

}

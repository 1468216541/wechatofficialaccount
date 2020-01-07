package com.wechat.demo.module.wechat.utils;

import com.alibaba.fastjson.JSONObject;
import com.wechat.demo.common.HttpUtils;
import com.wechat.demo.constant.InvariableAttribute;
import com.wechat.demo.module.wechat.service.CoreSevice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TemplateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");

    protected static String sendTemplate(JSONObject data){
        return HttpUtils.sendPostJson(data, InvariableAttribute.SEND_TEMPLATE + CoreSevice.getAccessToken());
    }

    public static String sendSubscribe(String openId){
        JSONObject outMap = new JSONObject();
        //openid
        outMap.put("touser",openId);
        //模板id
        outMap.put("template_id", InvariableAttribute.SUBSCRIBE_TEMPLATE);
        //上方颜色
        outMap.put("topcolor","#FF0000");
        Map<String,Object> dataMap = new HashMap<>();
        //标题
        Map<String,Object> firstMap = new HashMap<>();
        firstMap.put("value","谢谢您的订阅！");
        firstMap.put("color","#173177");
        //订阅时间
        Map<String,Object> keyword1Map = new HashMap<>();
        keyword1Map.put("value",sdf.format(new Date(System.currentTimeMillis())));
        keyword1Map.put("color","#173177");
        //结尾
        Map<String,Object> remarkMap = new HashMap<>();
        remarkMap.put("value","马上开始使用吧！");
        remarkMap.put("color","#173177");
        dataMap.put("first",firstMap);
        dataMap.put("keyword1",keyword1Map);
        dataMap.put("remark",remarkMap);
        outMap.put("data",dataMap);
        String result = sendTemplate(outMap);
        System.err.println(result);
        return InvariableAttribute.RETURN_SUCCESS;
    }

}

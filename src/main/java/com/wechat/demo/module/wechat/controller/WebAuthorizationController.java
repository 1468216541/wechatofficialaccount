package com.wechat.demo.module.wechat.controller;

import com.alibaba.fastjson.JSONObject;
import com.wechat.demo.common.HttpUtils;
import com.wechat.demo.constant.InvariableAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 网页授权
 */
@Controller
public class WebAuthorizationController {

    @RequestMapping("/login")
    public ModelAndView webAuthorization(String code){
        System.err.println("进行网页授权");
        //此处日志打印一下code,容易出错
        System.err.println(code);
        String param = code;
        String result = HttpUtils.doGet(InvariableAttribute.VIEW_GET_ACC_TOKEN.replaceAll("CODE",param),null);
        JSONObject viewData = JSONObject.parseObject(result);
        String openid = viewData.getString("openid");
        String accessToken =viewData.getString("access_token");
//        String unionId = viewData.getString("unionid");
        String userInfo = HttpUtils.doGet(InvariableAttribute.VIEW_GET_USERINFO.replaceAll("ACCESS_TOKEN",accessToken).replaceAll("OPENID",openid),null);
        JSONObject userInfoJson = JSONObject.parseObject(userInfo);
        String headImgUrl = userInfoJson.getString("headimgurl");
        String nickName = userInfoJson.getString("nickname");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url",headImgUrl.replaceAll("\\\\",""));
        modelAndView.addObject("name",nickName);
        modelAndView.addObject("openId",openid);
        modelAndView.setViewName("index");
        System.err.println("url --- " + headImgUrl);
        System.err.println("nickName --- " + nickName);
        System.err.println("openid --- " + openid);
        return modelAndView;
    }


}

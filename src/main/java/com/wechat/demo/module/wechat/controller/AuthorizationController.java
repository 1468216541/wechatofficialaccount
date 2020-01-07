package com.wechat.demo.module.wechat.controller;

import com.wechat.demo.common.AuthorizationUtil;
import com.wechat.demo.constant.InvariableAttribute;
import com.wechat.demo.module.wechat.service.CoreSevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {

    private final static Logger log = LoggerFactory.getLogger(AuthorizationController.class);

    @Autowired
    CoreSevice coreSevice;

    @GetMapping("/login")
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("----开始请求检验-----");
        String signature = request.getParameter("signature");
        log.info("获取到<" + signature + ">");
        String timestamp = request.getParameter("timestamp");
        log.info("获取到<" + timestamp + ">");
        String nonce = request.getParameter("nonce");
        log.info("获取到<" + nonce + ">");
        String echostr = request.getParameter("echostr");
        log.info("获取到<" + echostr + ">");
        PrintWriter print = response.getWriter();
        if (AuthorizationUtil.CheckSignature(signature,timestamp,nonce)){
            print.write(echostr);
        }
        print.flush();
        print.close();
    }

    @PostMapping("/login")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        String result = coreSevice.pareRequest(request);
        if(InvariableAttribute.RETURN_SUCCESS.equals(result)){
            out.print(InvariableAttribute.RETURN_SUCCESS);
        }else {
            out.print(result);
        }
        out.flush();
        out.close();
    }


}

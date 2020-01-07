package com.wechat.demo.module.wechat.model;

import lombok.Data;

@Data
public class AccessTokenModel {

    private String accessToken;

    private long expireTime;

    public AccessTokenModel(String accessToken,String expireIn){
        this.accessToken = accessToken;
        expireTime = System.currentTimeMillis() + Integer.parseInt(expireIn) * 1000;
    }

    public boolean isExpired(){
        return System.currentTimeMillis() > expireTime;
    }
}

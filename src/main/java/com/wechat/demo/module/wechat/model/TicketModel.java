package com.wechat.demo.module.wechat.model;

import lombok.Data;

@Data
public class TicketModel {
    private String ticket;

    private long expireTime;
    public TicketModel(String ticket,String expireIn){
        this.ticket = ticket;
        expireTime = System.currentTimeMillis() + Integer.parseInt(expireIn) * 1000;
    }
    public boolean isExpired(){
        return System.currentTimeMillis() > expireTime;
    }
}

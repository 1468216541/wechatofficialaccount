package com.wechat.demo.module.wechat.model;

import lombok.Data;

@Data
public class PhotoList {
    private String photoUrl;

    @Override
    public String toString() {
        return "PhotoList{" +
                "photoUrl='" + photoUrl + '\'' +
                '}';
    }
}

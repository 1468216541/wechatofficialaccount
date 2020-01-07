package com.wechat.demo.module.wechat.model;

import lombok.Data;

import java.util.List;
@Data
public class BasePoi {

    private String id;

    private String businessName;

    private String branchName;

    private String province;

    private String city;

    private String distrit;

    private String address;

    private String telephone;

    private List<String> categories;

    private Integer offsetType;

    private Double longitude;

    private Double latitude;

    private String recommend;

    private String special;

    private String intoduction;

    private String openTime;

    private Integer avgPrice;

    private List<PhotoList> phontoList;

    @Override
    public String toString() {
        return "BasePoi{" +
                "id='" + id + '\'' +
                ", businessName='" + businessName + '\'' +
                ", branchName='" + branchName + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", distrit='" + distrit + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", categories=" + categories +
                ", offsetType=" + offsetType +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", recommend='" + recommend + '\'' +
                ", special='" + special + '\'' +
                ", intoduction='" + intoduction + '\'' +
                ", openTime='" + openTime + '\'' +
                ", avgPrice=" + avgPrice +
                ", phontoList=" + phontoList +
                '}';
    }
}

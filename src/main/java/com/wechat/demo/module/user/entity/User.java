package com.wechat.demo.module.user.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2019-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID = 5117490865009493507L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String subscribe;
    private String openid;
    private String nickname;
    private String sex;
    private String language;
    private String city;
    private String province;
    private String country;
    private String headimgurl ;
    private String subscribeTime;
    private String remark;
    private String groupid;
    private String subscribeScen;
    private String qrScene;
    private String qrSceneStr;
    private Date createTime;
    private String res1;
    private String res2;
    private String res3;
}

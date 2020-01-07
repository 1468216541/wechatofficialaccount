package com.wechat.demo.module.user.service;

import com.wechat.demo.module.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2019-11-30
 */
public interface IUserService extends IService<User> {

    boolean saveUserInfo(String openId);

}

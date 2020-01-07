package com.wechat.demo.module.user.mapper;

import com.wechat.demo.module.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2019-11-30
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

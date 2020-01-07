package com.wechat.demo.module.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wechat.demo.common.HttpUtils;
import com.wechat.demo.constant.InvariableAttribute;
import com.wechat.demo.module.user.entity.User;
import com.wechat.demo.module.user.mapper.UserMapper;
import com.wechat.demo.module.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.demo.module.wechat.service.CoreSevice;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2019-11-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public boolean saveUserInfo(String openId) {
        String userInfo = HttpUtils.doGet(InvariableAttribute.GET_USERINFO.replaceAll("openid123",openId).
                replaceAll("token123", CoreSevice.getAccessToken()),null);
        JSONObject jsonObject = JSONObject.parseObject(userInfo);
        User user = new User();
        String subscribe = jsonObject.getString("subscribe");//用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
        user.setSubscribe(Integer.parseInt(subscribe) == 0 ? "未关注" : "已关注");
        String openid = jsonObject.getString("openid");//用户的标识，对当前公众号唯一
        user.setOpenid(openid);
        String nickname = jsonObject.getString("nickname");//用户的昵称
        user.setNickname(nickname);
        String sex = jsonObject.getString("sex");//用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
        user.setSex(Integer.parseInt(sex) == 1 ? "男" : (Integer.parseInt(sex) == 2 ?"女":"未知"));
        String language = jsonObject.getString("language");//用户的语言，简体中文为zh_CN
        user.setLanguage(language);
        String city = jsonObject.getString("city");//用户所在城市
        user.setCity(city);
        String province = jsonObject.getString("province");//用户所在省份
        user.setProvince(province);
        String country = jsonObject.getString("country");//用户所在国家
        user.setCountry(country);
        String headimgurl = jsonObject.getString("headimgurl");//用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
        user.setHeadimgurl(headimgurl);
        String subscribeTime = jsonObject.getString("subscribe_time");//用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
        user.setSubscribeTime(subscribeTime);
        String remark = jsonObject.getString("remark");//公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
        user.setRemark(remark);
        String groupid = jsonObject.getString("groupid");//用户所在的分组ID（兼容旧的用户分组接口）
        user.setGroupid(groupid);
        //返回用户关注的渠道来源，
        // ADD_SCENE_SEARCH 公众号搜索，
        // ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，
        // ADD_SCENE_PROFILE_CARD 名片分享
        // ADD_SCENE_QR_CODE 扫描二维码，
        // ADD_SCENE_PROFILE_ LINK 图文页内名称点击，
        // ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，
        // ADD_SCENE_PAID 支付后关注，
        // ADD_SCENE_OTHERS 其他
        String subscribeScene = jsonObject.getString("subscribe_scene");
        user.setSubscribeScen(subscribeScene.equals("ADD_SCENE_SEARCH") ? "公众号搜索": (subscribeScene.equals("ADD_SCENE_ACCOUNT_MIGRATION") ? "公众号迁移": (subscribeScene.equals("ADD_SCENE_PROFILE_CARD") ? "名片分享":
                (subscribeScene.equals("ADD_SCENE_QR_CODE") ? "扫描二维码": (subscribeScene.equals("ADD_SCENE_PROFILE_ LINK") ? "图文页内名称点击": (subscribeScene.equals("ADD_SCENE_PROFILE_ITEM") ? "图文页右上角菜单": (subscribeScene.equals("ADD_SCENE_PAID") ? "支付后关注": "其他")))))));
        String qrScene = jsonObject.getString("qr_scene");//二维码扫码场景（开发者自定义）
        user.setQrScene(qrScene);
        String qrSceneStr = jsonObject.getString("qr_scene_str");//二维码扫码场景描述（开发者自定义）
        user.setQrSceneStr(qrSceneStr);
        return user.insert();
    }

}

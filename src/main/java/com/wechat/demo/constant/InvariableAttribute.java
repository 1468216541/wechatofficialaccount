package com.wechat.demo.constant;

public class InvariableAttribute {
    //设置的token
    public static final String TOKEN = "weixin";

    //appid
    public static final String APPID = "wx4e872647c4821331";

    //appsecret
    public static final String APPSECRET = "8d85c8612575b66287bc01f3d3a0bee6";

    //接收微信服务器返回的请求成功的标志位
    public static final String RETURN_SUCCESS = "success";

    //订阅事件
    public static final String SUBSCRIBE = "subscribe";

    //取消订阅事件
    public static final String UNSUBSCRIBE = "unsubscribe";

    public static final String CLICK = "CLICK";

    //上传图文消息素材
    public static final String UPLOADPAGSC = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=";

    //获取access_token的url
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+APPSECRET;

    //使用模板消息的url
    public static final String SEND_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";

    //上传图片的接口
    public static final String UPLOADIMG = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=";

    //获取unionId的url
    //TODO 替换token为access_token,openid为openid
    public static final String GET_USERINFO = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=token123&openid=openid123&lang=zh_CN";

    //订阅提醒
    public static final String SUBSCRIBE_TEMPLATE = "18B7jSI4U0HVz_NNOI4ZsvJnoVuZQcgM1bhhNL5nWQY";

    //网页授权认证
    public static final String OAUTH_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + APPID + "&redirect_uri=" + "http%3A%2F%2F13a12d54.ngrok.io%2Fwechat%2Flogin" + "&response_type=code&scope=" + "snsapi_userinfo" + "&state=STATE#wechat_redirect";

    //网页获取access_token
    public static final String VIEW_GET_ACC_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+APPID+"&secret="+APPSECRET+"&code=CODE&grant_type=authorization_code";

    //网页获取用户信息
    public static final String VIEW_GET_USERINFO = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    //创建自定义菜单url
    public static final String CREATE_ZIDINGYI_CAIDAN = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";

    //自定义菜单删除url
    public static final String DELETE_ZIDINGYI_CAIDAN = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";

    //获取签名
    public static final String GET_SIGNATURE = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

    //获取所有关注公众号没有存入DB的用户信息
    public static final String USERALL_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=";

    //获取模板消息的id的url
    public static final String GET_TEMPLATE_ID = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=";

    //获取所有模板信息的url
    public static final String GET_ALL_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=";

    //获取设置的行业信息的url
    public static final String SET_INDUSTRY = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=";

    //获取设置的行业信息的url
    public static final String GET_INDUSTRY = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=";

    //创建门店的url
    public static final String CREATE_POI_URL = "http://api.weixin.qq.com/cgi-bin/poi/addpoi?access_token=";

    //卡劵id
    public static final String CARDID = "pBehx5lJX3nEfWbnXuz_L3D__Wk4";

    //创建卡劵的url
    public static final String CREATA_CARD_URL = "https://api.weixin.qq.com/card/create?access_token=";

    //测试白名单的url
    public static final String TEST_BAI_MING_DAN_URL = "https://api.weixin.qq.com/card/testwhitelist/set?access_token=";

    //图文非自定义code下发卡劵
    public static final String TUWEN_NO_CODE_URL = "https://api.weixin.qq.com/card/mpnews/gethtml?access_token=";

    //领取卡劵的页面
    public static final String LINGRU_HTML = "<iframe class=\\\"res_iframe card_iframe js_editor_card\\\" data-src=\\\"http:\\/\\/mp.weixin.qq.com\\/bizmall\\/appmsgcard?action=show&amp;biz=Mzg2NjIyNDY0NQ%3D%3D&amp;cardid=pBehx5lJX3nEfWbnXuz_L3D__Wk4&amp;wechat_card_js=1#wechat_redirect\\\"><\\/iframe>";

    //永久二维码请求
    public static final String ERWEIMA_YONGJIU = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";

    //新增永久图文素材
    public static final String YONGJIU_TUWEN_URL = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=";

    //上传多媒体文件
    public static final String SHANGCHUAN_DUOMEITI_WENJIAN = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=";

    //获取永久media_id的url
    public static final String YONGJIUSUCAITHUMBID = "https://api.weixin.qq.com/cgi-bin/material/add_material?type=thumb&access_token=";

    public static final String GET_THUMB_MEDIA_ID = "http://file.api.weixin.qq.com/cgi-bin/media/upload?type=thumb&access_token=";

    //群发消息
    public static final String MASS_TEXTING = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=";

    //发送图文素材
    public static final String SENDTUWENSUCAIURL = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=";

//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String url = URLEncoder.encode("http://13a12d54.ngrok.io/wechat/login","UTF-8");
//        System.err.println(url);
//    }
}

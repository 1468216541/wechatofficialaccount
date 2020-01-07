## 一、简介 
- 基于SpringBoot对微信公众号的开发
- module中的wechat为微信公众号的主要业务
- common中验证微信服务器、http请求工具类和对象解析为xml
- constant中存放请求连接、TOKEN、APPID、APPSECRET
## 二、使用
1、修改TOKEN、APPID、APPSECRET

2、回复用户文本消息,在module下面的wechat里面找到ProcessingMsg这个类
```
    case MsgTypeUtil.RETURN_MSG_TYPE_TEXT :
        {
            TextMessage textMessage = (TextMessage) map.get("textMessage");
            String content = textMessage.getContent();
            if ("1".equals(content)){
                //content为用户发送的信息
                //result为回复用户的信息
                result = "什么1？";
            }else {
                result = "公众号未接入自动聊天功能。请及时联系管理员(***********)";
            }
            //组装回复用户的信息
            textMessage.setContent(result);
            result = MsgTypeUtil.textMessageToXml(textMessage);
            return result;
        }
```
3、关注后推送一条模板消息,找到ProcessingMsg的如下代码
```
    //订阅操作
    case InvariableAttribute.SUBSCRIBE:
    {
        //调用微信提供接口获取用户所有信息存入DB
        UserServiceImpl userService = (UserServiceImpl) map.get("userService");
        userService.saveUserInfo(openId);
        //调用模板消息(具体实现详见TemplateUtil类)
        return TemplateUtil.sendSubscribe(openId);
    }
```
4、网页授权
```
    //网页授权认证 将InvariableAttribute中的OAUTH_URL进行修改即可
    public static final String OAUTH_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + APPID + "&redirect_uri=" + "http%3A%2F%2F13a12d54.ngrok.io%2Fwechat%2Flogin" + "&response_type=code&scope=" + "snsapi_userinfo" + "&state=STATE#wechat_redirect";
    redirect_uri:为服务器跳转视图接口用URLEncode转码
    
    String url = URLEncoder.encode("http://13a12d54.ngrok.io/wechat/login","UTF-8");

    具体实现类在WebAuthorizationController中

```
5、自定义菜单的创建(MenuUtil类中)
```
 public static String createMenu(){
        JSONObject result = new JSONObject();
        //此处根据具体业务进行修改
        //一级菜单
        JSONObject btn01 = createButton(0,"一级菜单","test1");
        JSONObject btn02 = createButton(1,"跳百度",null,"http://www.baidu.com");
        JSONObject subMenusJson = new JSONObject();
        JSONArray subMenusArrary = new JSONArray();
        //创建二级菜单
        JSONObject btn03 = createButton(1,"百度",null,"http://www.baidu.com");
        JSONObject btn04 = createButton(0,"菜单","test12");
        //将创建的二级菜单添加到二级btn中
        subMenusArrary.add(btn03);
        subMenusArrary.add(btn04);
        //二级菜单的名字
        subMenusJson.put("name","二级菜单");
        subMenusJson.put("sub_button",subMenusArrary);

        JSONArray resultArray = new JSONArray();
        //将创建的一级菜单按钮添加到btn中
        resultArray.add(btn01);
        resultArray.add(btn02);
        resultArray.add(subMenusJson);
        result.put("button",resultArray);
        String data = HttpUtils.sendPostJson(result, InvariableAttribute.CREATE_ZIDINGYI_CAIDAN + CoreSevice.getAccessToken());
        System.err.println(result);
        return data;
    }
```

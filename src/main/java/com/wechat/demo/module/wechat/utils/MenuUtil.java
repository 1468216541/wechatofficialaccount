package com.wechat.demo.module.wechat.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wechat.demo.common.HttpUtils;
import com.wechat.demo.constant.InvariableAttribute;
import com.wechat.demo.module.wechat.service.CoreSevice;

import java.io.File;


/**
 * 自定义菜单操作
 */
public class MenuUtil {

    /**
     * 创建自定义菜单
     * @return
     */
    public static String createMenu(){
        JSONObject result = new JSONObject();
        JSONObject btn01 = createButton(0,"一级菜单","test1");
        JSONObject btn02 = createButton(1,"跳百度",null,"http://www.baidu.com");
        JSONObject subMenusJson = new JSONObject();
        JSONArray subMenusArrary = new JSONArray();
        JSONObject btn03 = createButton(1,"百度",null,"http://www.baidu.com");
        JSONObject btn04 = createButton(0,"菜单","test12");
        subMenusArrary.add(btn03);
        subMenusArrary.add(btn04);
        subMenusJson.put("name","二级菜单");
        subMenusJson.put("sub_button",subMenusArrary);

        JSONArray resultArray = new JSONArray();
        resultArray.add(btn01);
        resultArray.add(btn02);
        resultArray.add(subMenusJson);
        result.put("button",resultArray);
        String data = HttpUtils.sendPostJson(result, InvariableAttribute.CREATE_ZIDINGYI_CAIDAN + CoreSevice.getAccessToken());
        System.err.println(result);
        return data;
    }

    /**
     * 删除自定义菜单
     * @return
     */
    public static String deleteMenu(){

        return null;
    }

    /**
     *
     * @param code  0:点击事件的按钮    1:跳转url的按钮      2:生成跳转小程序的按钮
     * @param strings 一共五个参数 如果填入第一个和第三个参数，将第二个参数传入空,后面参数可不填
     *                后面可以省略,中间没有值的必须传入null
     *                第一个参数:    按钮的名字
     *                第二个参数:    按钮的key
     *                第三个参数:    按钮跳转的url
     *                第四个参数:    跳转小程序的appid
     *                第五个参数:    跳转小程序的路径
     * @return
     */
    private static JSONObject createButton(int code,String ... strings){
        String name = strings[0];
        String key = strings[1];
        String url = (strings.length > 2) ? strings[2] : "";
        String appid = (strings.length > 3) ? strings[3] : "";
        String path = (strings.length > 3) ? strings[4] : "";
        JSONObject btnJson = new JSONObject();
        switch (code){
            //点击事件按钮
            case 0:
            {
                btnJson.put("type","click");
                btnJson.put("name",name);
                btnJson.put("key",key);
                return btnJson;
            }
            //跳转url按钮
            case 1:
            {
                btnJson.put("type","view");
                btnJson.put("name",name);
                btnJson.put("url",url);
                return btnJson;
            }
            //跳转小程序的按钮
            case 2:
            {
                btnJson.put("name",name);
                btnJson.put("type","miniprogram");
                btnJson.put("url","http://mp.weixin.qq.com");
                btnJson.put("appid",appid);
                btnJson.put("pagepath",path);
                return btnJson;
            }
        }
        return null;
    }

//    public static void main(String[] args) {
//        System.err.println(createMenu());
//        File file = new File("C:\\Users\\Administrator\\Desktop\\3.jpg");
//        String url = HttpUtils.getMediaId(file,InvariableAttribute.GET_THUMB_MEDIA_ID + CoreSevice.getAccessToken());
//        System.err.println(url);
//        System.err.println(JSONObject.parseObject(url).getString("thumb_media_id"));
//    }
}

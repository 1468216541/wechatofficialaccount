package com.wechat.demo.common;

import com.wechat.demo.constant.InvariableAttribute;

import java.security.MessageDigest;
import java.util.Arrays;

public class AuthorizationUtil {
    //进行字典排序
    public static boolean CheckSignature(String signature,String timestamp,String nonce){
        String[] arr = new String[]{InvariableAttribute.TOKEN,timestamp,nonce};
        Arrays.sort(arr);
        StringBuffer content = new StringBuffer();
        for(int i = 0;i<arr.length;i++){
            content.append(arr[i]);
        }
        String temp = getShal(content.toString());
        return temp.equals(signature);
    }

    //进行sha1加密
    public static String getShal(String str){
        if(null ==str || 0 == str.length()){
            return null;
        }
        char[] hexDigts = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] buf = new char[j*2];
            int k = 0;
            for(int i = 0 ; i < j ; i ++){
                byte byte0 = md[i];
                buf[k++] = hexDigts[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigts[byte0 & 0xf];
            }
            return new String(buf);
        }catch (Exception e){
            return null;
        }
    }
}

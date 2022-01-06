package com.zhu.onemanager.utlis;

import cn.hutool.core.lang.Dict;
import cn.hutool.http.*;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName GHttpUtil.java
 * @Description TODO
 * @createTime 2021年12月17日 17:02:00
 */
public class GHttpUtil extends HttpUtil {

    /*get请求*/
    public static Map getResMap(String urlString) {
        String res = get(urlString, HttpGlobalConfig.getTimeout());
        return JSONObject.parseObject(res, Map.class);
    }

    public static Dict getResDict(String urlString) {
        Map resMap = getResMap(urlString);
        return Dict.parse(resMap);
    }

    public static Map postResMap(String urlString,String body) {
        String res = post(urlString, body);
        return JSONObject.parseObject(res, Map.class);
    }

    /*post请求*/
    public static Dict postResDict(String urlString,String body) {
        Map resMap = postResMap(urlString,body);
        return Dict.parse(resMap);
    }

    public static void putHeaders(String name,String value) {
        GlobalHeaders instance = GlobalHeaders.INSTANCE;
        instance.header(name,value);
    }

    /*put请求*/

    public static Dict put(String url,byte[] values,String contentType) {
        String res = HttpRequest.put(url).contentType(contentType).body(values).execute().body();
        return Dict.parse(JSONObject.parseObject(res, Map.class));

    }

}

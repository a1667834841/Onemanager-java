package com.zhu.onemanager.utlis;

import cn.hutool.http.GlobalHeaders;
import cn.hutool.http.HttpGlobalConfig;
import cn.hutool.http.HttpUtil;
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

    public static Map getMap(String urlString) {
        String res = get(urlString, HttpGlobalConfig.getTimeout());
        return JSONObject.parseObject(res, Map.class);
    }

    public static void putHeaders(String name,String value) {
        GlobalHeaders instance = GlobalHeaders.INSTANCE;
        instance.header(name,value);
    }
}

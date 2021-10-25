package com.dnslin.onemanagerjava.logic.impl;

import cn.hutool.core.util.RandomUtil;
import com.dnslin.onemanagerjava.logic.AuthUrl;


public class AuthUrlImpl implements AuthUrl {

    /**
    *
     *功能描述
     * @author dnslin
     * @date 2021/10/25
     * @param clientId 客户端ID
     * @param redirectUri 回调URL
     * @return AuthUrl 重定向url
     */
    @Override
    public String getAuthUrl(String clientId, String redirectUri) {
        String state = RandomUtil.randomString(10);
        return String.format("https://login.microsoftonline.com/common/oauth2/v2.0/authorize?" +
                "client_id=%s" +
                "&response_type=code" +
                "&redirect_uri=%s" +
                "&response_mode=query" +
                "&scope=files.readwrite.all files.readwrite offline_access" +
                "&state=%s", clientId, redirectUri, state);
    }
}

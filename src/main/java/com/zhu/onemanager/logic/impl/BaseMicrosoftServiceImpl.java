package com.zhu.onemanager.logic.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.zhu.onemanager.logic.BaseMicrosoftService;
import com.zhu.onemanager.pojo.OnedriveConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName BaseMicrosoftServiceImpl.java
 * @Description TODO
 * @createTime 2021年12月12日 03:55:00
 */
@Service
public class BaseMicrosoftServiceImpl implements BaseMicrosoftService {


    @Value("${onedrive.scope}")
    private String scope;
    @Value("${onedrive.clientSecret}")
    private String clientSecret;
    @Value("${onedrive.redirectUri}")
    private String redirectUri;
    @Value("${onedrive.clientId}")
    private String clientId;
    @Value("${onedrive.authenticateEndPoint}")
    private String authenticateEndPoint;


    @Value("${onedrive.file.scope}")
    private String fileScope;
    @Value("${onedrive.file.redirectUri}")
    private String fileRedirectUri;
    @Value("${onedrive.file.clientId}")
    private String fileClientId;
    @Value("${onedrive.file.clientSecret}")
    private String fileClientSecret;



    protected static final String AUTHENTICATE_URL = "https://{authenticateEndPoint}/common/oauth2/v2.0/token";



    @Override
    public OnedriveConfig getOutlookToken(String code) {
        String param = "client_id=" + fileClientId +
                "&redirect_uri=" + redirectUri +
                "&client_secret=" + clientSecret +
                "&code=" + code +
                "&scope=" + scope +
                "&grant_type=authorization_code";

        String fullAuthenticateUrl = AUTHENTICATE_URL.replace("{authenticateEndPoint}", authenticateEndPoint);
        HttpRequest post = HttpUtil.createPost(fullAuthenticateUrl);

        post.body(param, "application/x-www-form-urlencoded");
        HttpResponse response = post.execute();
        return JSONObject.parseObject(response.body(), OnedriveConfig.class);
    }

    @Override
    public OnedriveConfig getFileToken(String code) {
        String param = "client_id=" + fileClientId +
                "&redirect_uri=" + fileRedirectUri +
                "&client_secret=" + fileClientSecret +
                "&code=" + code +
                "&scope=" + fileScope +
                "&grant_type=authorization_code";

        String fullAuthenticateUrl = AUTHENTICATE_URL.replace("{authenticateEndPoint}", authenticateEndPoint);
        HttpRequest post = HttpUtil.createPost(fullAuthenticateUrl);

        post.body(param, "application/x-www-form-urlencoded");
        HttpResponse response = post.execute();
        return JSONObject.parseObject(response.body(), OnedriveConfig.class);
    }

    private String getScope() {
        return "offline_access User.Read openid Mail.Read";
    }

    private String getClientSecret() {
        return "q847Q~yGYv6_GasCcKRaLF4syQUqpVz5D_HoH";
    }

    private String getRedirectUri() {
        return "http://localhost:8081/api/outlook";
    }

    private String getClientId() {
        return "0d5e84db-18cf-4ab7-bc67-4af2dc9bce6b";
    }

    public String getAuthenticateEndPoint() {
        return "login.microsoftonline.com";
    }


}

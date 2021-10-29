package com.dnslin.onemanager.logic.impl;

import cn.hutool.core.lang.Console;
import com.alibaba.fastjson.JSONObject;
import com.dnslin.onemanager.exception.AppException;
import com.dnslin.onemanager.logic.AuthToken;
import com.dnslin.onemanager.result.ResponseEnum;
import com.dnslin.onemanager.utils.HttpClientUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取TOKen
 *
 * @author dnslin
 * @date 2021/10/25 20:10
 * @ProjectName: OneManager-java
 * @url: https://login.microsoftonline.com/common/oauth2/v2.0/token
 * @return AuthToken
 * @Version 1.0
 */
public class AuthTokenImpl extends HttpServlet implements AuthToken {
    private final ServletContext context = this.getServletContext();

    @Override
    public void getAccessToken(String clientId, String redirectUri, String clientSecret) {
        String code = (String) context.getAttribute("code");
        if (code == null || code.isEmpty()) {
            throw new AppException(ResponseEnum.AUTH_CODE_ISNULL);
        }
        Map<String, String> param = new HashMap<String, String>();
        param.put("client_id", clientId);
        param.put("scope", "files.readwrite.all files.readwrite offline_access");
        param.put("code", code);
        param.put("redirect_uri", redirectUri);
        param.put("grant_type", "authorization_code");
        param.put("client_secret", clientSecret);
        extracted(HttpClientUtils.doPost("https://login.microsoftonline.com/common/oauth2/v2.0/token", param).getContent());
    }

    @Override
    public void getRefreshToken(String clientId, String redirectUri, String clientSecret) {
        if ((context.getAttribute("refresh_token") == null && context.getAttribute("refresh_token").toString().isEmpty()) || (context.getAttribute("access_token") == null && context.getAttribute("access_token").toString().isEmpty())) {
            Console.log("Refresh_token:==>" + context.getAttribute("refresh_token"));
            Console.log("Access_token:==>" + context.getAttribute("access_token"));
            throw new AppException(ResponseEnum.Token_invalid);
        }
        Map<String, String> param = new HashMap<String, String>();
        param.put("client_id", clientId);
        param.put("scope", "files.readwrite.all files.readwrite offline_access");
        param.put("refresh_token", context.getAttribute("refresh_token").toString());
        param.put("redirect_uri", redirectUri);
        param.put("grant_type", "refresh_token");
        param.put("client_secret", clientSecret);
        extracted(HttpClientUtils.doPost("https://login.microsoftonline.com/common/oauth2/v2.0/token", param).getContent());
    }

    /**
     *   抽出重复代码
     * @Description:
     * @param: accessJson
     * @return void
     * @author DnsLin
     * @date 2021/10/29 23:55
     */
    private void extracted(String accessJson) {
        if (accessJson == null || accessJson.isEmpty()) {
            throw new AppException(ResponseEnum.THE_RESULT_SET_IS_EMPTY);
        }
        Console.log("结果集accessJson:==>" + accessJson);
        String access_token = JSONObject.parseObject(accessJson).getString("access_token");
        String refresh_token = JSONObject.parseObject(accessJson).getString("refresh_token");
        Console.log("Access_token:==>" + access_token);
        Console.log("Refresh_token:==>" + refresh_token);
        context.setAttribute("access_token", access_token);
        context.setAttribute("refresh_token", refresh_token);
    }


}

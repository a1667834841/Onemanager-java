package com.dnslin.onemanager.logic.impl;

import cn.hutool.core.lang.Console;
import com.alibaba.fastjson.JSONObject;
import com.dnslin.onemanager.exception.AppException;
import com.dnslin.onemanager.logic.AuthToken;
import com.dnslin.onemanager.pojo.Onedriveconfig;
import com.dnslin.onemanager.result.ResponseEnum;
import com.dnslin.onemanager.service.SaveConfig;
import com.dnslin.onemanager.utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class AuthTokenImpl extends HttpServlet implements AuthToken {
    private final ServletContext context = this.getServletContext();

    @Autowired
    private SaveConfig saveConfig;
    @Override
    public void getAccessToken(Onedriveconfig config) {
        String code = (String) context.getAttribute("code");
        if (code == null || code.isEmpty()) {
            throw new AppException(ResponseEnum.AUTH_CODE_ISNULL);
        }
        Map<String, String> param = new HashMap<String, String>();
        param.put("client_id", config.getClientid());
        param.put("scope", "files.readwrite.all files.readwrite offline_access");
        param.put("code", code);
        param.put("redirect_uri", config.getRedirecturl());
        param.put("grant_type", "authorization_code");
        param.put("client_secret", config.getRedirecturl());
        extracted(HttpClientUtils.doPost("https://login.microsoftonline.com/common/oauth2/v2.0/token", param).getContent(),null);
    }

    @Override
    public void getRefreshToken(Onedriveconfig config) {
        if ((context.getAttribute("refresh_token") == null && context.getAttribute("refresh_token").toString().isEmpty()) || (context.getAttribute("access_token") == null && context.getAttribute("access_token").toString().isEmpty())) {
            Console.log("Refresh_token:==>" + context.getAttribute("refresh_token"));
            Console.log("Access_token:==>" + context.getAttribute("access_token"));
            throw new AppException(ResponseEnum.Token_invalid);
        }
        Map<String, String> param = new HashMap<String, String>();
        param.put("client_id", config.getClientid());
        param.put("scope", "files.readwrite.all files.readwrite offline_access");
        param.put("refresh_token", context.getAttribute("refresh_token").toString());
        param.put("redirect_uri", config.getRedirecturl());
        param.put("grant_type", "refresh_token");
        param.put("client_secret", config.getRedirecturl());
        extracted(HttpClientUtils.doPost("https://login.microsoftonline.com/common/oauth2/v2.0/token", param).getContent(),config);
    }

    /**
     * 抽出重复代码
     *
     * @return void
     * @Description:
     * @param: accessJson
     * @author DnsLin
     * @date 2021/10/29 23:55
     */
    private void extracted(String accessJson,Onedriveconfig config) {
        if (accessJson == null || accessJson.isEmpty()) {
            throw new AppException(ResponseEnum.THE_RESULT_SET_IS_EMPTY);
        }
        Console.log("结果集accessJson:==>" + accessJson);
        String access_token = JSONObject.parseObject(accessJson).getString("access_token");
        String refresh_token = JSONObject.parseObject(accessJson).getString("refresh_token");
        Console.log("Access_token:==>" + access_token);
        Console.log("Refresh_token:==>" + refresh_token);
        config.setAccesstoken(access_token);
        config.setRefreshtoken(refresh_token);
        context.setAttribute("OnedriveConfig", config);
        saveConfig.saveOnedriveConfig(config);
    }
}

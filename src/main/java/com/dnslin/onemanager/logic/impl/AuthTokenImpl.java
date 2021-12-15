package com.dnslin.onemanager.logic.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

import com.dnslin.onemanager.exception.AppException;
import com.dnslin.onemanager.logic.AuthToken;
import com.dnslin.onemanager.pojo.Onedriveconfig;
import com.dnslin.onemanager.result.ResponseEnum;
import com.dnslin.onemanager.service.SaveConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpUtils;
import java.io.IOException;
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
@Slf4j
public class AuthTokenImpl implements AuthToken {

    @Autowired
    private ServletContext context;

    @Resource
    private SaveConfig saveConfig;

    public AuthTokenImpl(SaveConfig saveConfig) {
        this.saveConfig = saveConfig;
    }

    @Override
    public void getAccessToken(Onedriveconfig config) throws IOException {
        String code = (String) context.getAttribute("code");
        if (code == null || code.isEmpty()) {
            throw new AppException(ResponseEnum.AUTH_CODE_ISNULL);
        }
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("client_id", config.getClientid());
        param.put("scope", "files.readwrite.all files.readwrite offline_access");
        param.put("code", code);
        param.put("redirect_uri", config.getRedirecturl());
        param.put("grant_type", "authorization_code");
        param.put("client_secret", config.getRedirecturl());
        String res = HttpUtil.post("https://login.microsoftonline.com/common/oauth2/v2.0/token", param,3000);
        extracted(res, config);
    }

    @Override
    public void getRefreshToken(Onedriveconfig config) throws IOException {
        if ((context.getAttribute("refresh_token") == null && context.getAttribute("refresh_token").toString().isEmpty()) || (context.getAttribute("access_token") == null && context.getAttribute("access_token").toString().isEmpty())) {
            log.info("Refresh_token:==>" + context.getAttribute("refresh_token"));
            log.info("Access_token:==>" + context.getAttribute("access_token"));
            throw new AppException(ResponseEnum.Token_invalid);
        }
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("client_id", config.getClientid());
        param.put("scope", "files.readwrite.all files.readwrite offline_access");
        param.put("refresh_token", context.getAttribute("refresh_token").toString());
        param.put("redirect_uri", config.getRedirecturl());
        param.put("grant_type", "refresh_token");
        param.put("client_secret", config.getRedirecturl());
        String res = HttpUtil.post("https://login.microsoftonline.com/common/oauth2/v2.0/token", param,3000);
        extracted(res, config);
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
    private void extracted(String accessJson, Onedriveconfig config) {
        if (accessJson == null || accessJson.isEmpty()) {
            throw new AppException(ResponseEnum.THE_RESULT_SET_IS_EMPTY);
        }
        log.info("结果集accessJson:==>" + accessJson);
        String access_token = JSONObject.parseObject(accessJson).getString("access_token");
        String refresh_token = JSONObject.parseObject(accessJson).getString("refresh_token");
        log.info("Access_token:==>" + access_token);
        log.info("Refresh_token:==>" + refresh_token);
        config.setAccesstoken(access_token);
        config.setRefreshtoken(refresh_token);
        context.setAttribute("OnedriveConfig", config);
        saveConfig.saveOnedriveConfig(config);
    }
}

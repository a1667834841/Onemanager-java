package com.zhu.onemanager.logic.impl;

import cn.hutool.http.GlobalHeaders;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

import com.zhu.onemanager.constant.FileConstant;
import com.zhu.onemanager.constant.PathConstant;
import com.zhu.onemanager.exception.AppException;
import com.zhu.onemanager.logic.AuthToken;
import com.zhu.onemanager.pojo.OnedriveConfig;
import com.zhu.onemanager.result.ResponseEnum;
import com.zhu.onemanager.service.SaveConfig;
import com.zhu.onemanager.utlis.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
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

//    @Resource
//    private SaveConfig saveConfig;
//
//    public AuthTokenImpl(SaveConfig saveConfig) {
//        this.saveConfig = saveConfig;
//    }

    @Override
    public void getAccessToken(OnedriveConfig config) throws IOException {
        String code = (String) context.getAttribute("code");
        if (code == null || code.isEmpty()) {
            throw new AppException(ResponseEnum.AUTH_CODE_ISNULL);
        }
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("client_id", config.getClientId());
        param.put("scope", config.getScope());
        param.put("code", code);
        param.put("redirect_uri", config.getRedirectUri());
        param.put("grant_type", "authorization_code");
        param.put("client_secret", config.getClientSecret());
        String res = HttpUtil.post("https://login.microsoftonline.com/common/oauth2/v2.0/token", param,3000);
        extracted(res, config);
    }

    @Override
    public void getRefreshToken(OnedriveConfig config) throws IOException {

        if (config == null) {
            throw new AppException(ResponseEnum.CONFIG_INVALID);
        }

        Map map = FileUtils.readMap(PathConstant.TOKEN_PATH, FileConstant.KV_SEPARATOR);
        if (null != map && map.size() > 0) {
            config.setRefreshToken(String.valueOf(map.get("refreshToken")));
        } else if (config.getRefreshToken() == null || config.getAccessToken() == null) {
            log.info("Refresh_token:==>" + context.getAttribute("refresh_token"));
            log.info("Access_token:==>" + context.getAttribute("access_token"));
            throw new AppException(ResponseEnum.TOKEN_INVALID);
        }
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("client_id", config.getClientId());
        param.put("scope", "files.readwrite.all files.readwrite offline_access");
        param.put("refresh_token", config.getRefreshToken());
        param.put("redirect_uri", config.getRedirectUri());
        param.put("grant_type", "refresh_token");
        param.put("client_secret", config.getClientSecret());
        String res = HttpUtil.post("https://login.microsoftonline.com/common/oauth2/v2.0/token", param,3000);
        extracted(res, config);
    }

    /**
     * 获取token 的后置处理 抽出重复代码
     *
     * @return void
     * @Description:
     * @param: accessJson
     * @author DnsLin
     * @date 2021/10/29 23:55
     */
    private void extracted(String accessJson, OnedriveConfig config) {
        if (accessJson == null || accessJson.isEmpty()) {
            throw new AppException(ResponseEnum.THE_RESULT_SET_IS_EMPTY);
        }
        log.info("结果集accessJson:==>" + accessJson);
        String access_token = JSONObject.parseObject(accessJson).getString("access_token");
        String refresh_token = JSONObject.parseObject(accessJson).getString("refresh_token");
        log.info("Access_token:==>" + access_token);
        log.info("Refresh_token:==>" + refresh_token);
        config.setAccessToken(access_token);
        config.setRefreshToken(refresh_token);
        context.setAttribute("OnedriveConfig", config);

        // 将token 存入请求头
        GlobalHeaders.INSTANCE.header("Authorization","bearer "+access_token);

        // token存入文件
        HashMap<String, String> tokenMap = new HashMap<>();
        tokenMap.put("accessToken",access_token);
        tokenMap.put("refreshToken",refresh_token);
        try {
            FileUtils.write(tokenMap, PathConstant.TOKEN_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //saveConfig.saveOnedriveConfig(config);
    }
}

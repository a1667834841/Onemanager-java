package com.dnslin.onemanager.logic.impl;

import com.dnslin.onemanager.exception.AppException;
import com.dnslin.onemanager.logic.AuthToken;
import com.dnslin.onemanager.result.ResponseEnum;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

/**
 * 获取TOKen
 *
 * @author dnslin
 * @date 2021/10/25 20:10
 * @ProjectName: Onemanager-java
 * @url: https://login.microsoftonline.com/common/oauth2/v2.0/token
 * @return AuthToken
 * @Version 1.0
 */
public class AuthTokenImpl extends HttpServlet implements AuthToken {
    private final ServletContext context = this.getServletContext();

    @Override
    public String getAccessToken(String clientId, String redirectUri) {
        String code  = (String)context.getAttribute("code");
        if (code != null && !code.isEmpty()){
            throw new AppException(ResponseEnum.SYSTEM_ERROR);
        }
        return null;
    }

    @Override
    public String getRefreshToken() {
        return null;
    }
}

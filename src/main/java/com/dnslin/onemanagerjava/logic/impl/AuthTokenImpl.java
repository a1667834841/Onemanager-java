package com.dnslin.onemanagerjava.logic.impl;

import com.dnslin.onemanagerjava.logic.AuthToken;

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
    public String getAccessToken() {
        String code  = (String)context.getAttribute("code");
        if (code != null && !code.isEmpty()){

        }
        return null;
    }

    @Override
    public String getRefreshToken() {
        return null;
    }
}

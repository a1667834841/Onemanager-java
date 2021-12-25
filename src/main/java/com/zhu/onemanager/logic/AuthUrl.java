package com.zhu.onemanager.logic;

public interface AuthUrl {

    /**
     * 功能描述
     * @author dnslin
     * @date 2021/10/25
     * @param clientId 客户端ID
     * @param redirectUri 回调URL
     * @param scope 权限
     * @return AuthUrl 重定向url
     */
    String getAuthUrl(String clientId, String redirectUri,String scope);
}

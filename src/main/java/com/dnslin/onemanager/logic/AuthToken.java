package com.dnslin.onemanager.logic;

/**
 * AuthToken
 * @author dnslin
 * @date 2021/10/25 13:38
 * @ProjectName: Onemanager-java
 * @Version 1.0
 */
public interface AuthToken {
    /**
     * 获取AccessToken
     * @author dnslin
     * @date 10/25
     * @param  clientId
     * @param  redirectUri
     * @param clientSecret
     * @return
     */
    void getAccessToken(String clientId, String redirectUri,String clientSecret);

    /**
    *  刷新Refresh_token和AccessToken
     * @Description:
     * @param: clientId
     * @param: redirectUri
     * @param: clientSecret
     * @return java.lang.String
     * @author DnsLin
     * @date 2021/10/29 23:38
    */
    void getRefreshToken(String clientId, String redirectUri,String clientSecret);
}

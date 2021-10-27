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
     * 功能描述 
     * @author dnslin
     * @date 10/25
     * @param  clientId
     * @param  redirectUri
     * @return
     */
    String getAccessToken(String clientId, String redirectUri);
    String getRefreshToken();
}

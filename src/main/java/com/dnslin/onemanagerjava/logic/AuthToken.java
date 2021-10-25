package com.dnslin.onemanagerjava.logic;

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
     * @param  client_id
     * @param  redirect_uri
     * @return
     */
    String getAccessToken();
    String getRefreshToken();
}

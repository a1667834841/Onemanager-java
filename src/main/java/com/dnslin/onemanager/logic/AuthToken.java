package com.dnslin.onemanager.logic;

import com.dnslin.onemanager.pojo.Onedriveconfig;

/**
 * AuthToken
 * @author dnslin
 * @date 2021/10/25 13:38
 * @ProjectName: Onemanager-java
 * @Version 1.0
 */

public interface AuthToken {
   /**
   *
    * @Description: 获取AccessToken
    * @param: config
    * @return void
    * @author DnsLin
    * @date 2021/10/31 18:40
   */
    void getAccessToken(Onedriveconfig config);

    /**
     *
     * @Description: 刷新Refresh_token和AccessToken
     * @param: config
     * @return void
     * @author DnsLin
     * @date 2021/10/31 18:40
     */
    void getRefreshToken(Onedriveconfig config);
}

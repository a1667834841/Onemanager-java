package com.zhu.onemanager.logic;

import com.zhu.onemanager.pojo.OnedriveConfig;

import java.io.IOException;

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
    void getAccessToken(OnedriveConfig config) throws IOException;

    /**
     *
     * @Description: 刷新Refresh_token和AccessToken
     * @param: config
     * @return void
     * @author DnsLin
     * @date 2021/10/31 18:40
     */
    void getRefreshToken(OnedriveConfig config) throws IOException;
}

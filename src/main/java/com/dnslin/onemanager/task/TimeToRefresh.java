package com.dnslin.onemanager.task;/**
 * @author: DnsLin
 * @Title: TimeToRefresh
 * @ProjectName: Onemanager-java
 * @Description:
 * @date: 2021/10/30 0:12
 */

import com.dnslin.onemanager.logic.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author: DnsLin
 * @Title: TimeToRefresh
 * @ProjectName: Onemanager-java
 * @Description:
 * @date: 2021/10/30 0:12
 */
@Component
public class TimeToRefresh {

    @Autowired
    private AuthToken authToken;

    @Scheduled(fixedRate = 1000 * 60 * 29, initialDelay = 1000 * 290)
    public void runGetToken(){
//        authToken.getRefreshToken(clientId,redirectUri,clientSecret);
    }

}

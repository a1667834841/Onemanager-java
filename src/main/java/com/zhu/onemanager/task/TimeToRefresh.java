package com.zhu.onemanager.task;

import com.zhu.onemanager.logic.AuthToken;
import com.zhu.onemanager.pojo.OnedriveConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.IOException;

/**
 * @author: DnsLin
 * @Title: TimeToRefresh
 * @ProjectName: Onemanager-java
 * @Description:
 * @date: 2021/10/30 0:12
 */
@Component
public class TimeToRefresh  {

    @Autowired
    private AuthToken authTokenImpl;

    @Autowired
    private OnedriveConfig config;

    @Scheduled(fixedRate = 1000 * 60 * 30, initialDelay = 1000 * 5)
    public void runGetToken() throws IOException {
        authTokenImpl.getRefreshToken(config);
    }

}

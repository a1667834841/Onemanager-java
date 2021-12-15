package com.dnslin.onemanager.task;

import com.dnslin.onemanager.logic.AuthToken;
import com.dnslin.onemanager.pojo.Onedriveconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
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
    private ServletContext context;

    @Scheduled(fixedRate = 1000 * 60 * 29, initialDelay = 1000 * 290)
    public void runGetToken() throws IOException {
        Onedriveconfig config = (Onedriveconfig) context.getAttribute("OnedriveConfig");
        authTokenImpl.getRefreshToken(config);
    }

}

package com.dnslin.onemanager.task;

import com.dnslin.onemanager.logic.AuthToken;
import com.dnslin.onemanager.pojo.Onedriveconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

/**
 * @author: DnsLin
 * @Title: TimeToRefresh
 * @ProjectName: Onemanager-java
 * @Description:
 * @date: 2021/10/30 0:12
 */
@Component
public class TimeToRefresh extends HttpServlet {

    @Autowired
    private AuthToken authTokenImpl;

    private final ServletContext context = this.getServletContext();

    @Scheduled(fixedRate = 1000 * 60 * 29, initialDelay = 1000 * 290)
    public void runGetToken() {
        Onedriveconfig config = (Onedriveconfig) context.getAttribute("OnedriveConfig");
        authTokenImpl.getRefreshToken(config);
    }

}

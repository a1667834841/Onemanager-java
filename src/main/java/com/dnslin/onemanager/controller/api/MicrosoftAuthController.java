package com.dnslin.onemanager.controller.api;

/**
 * @author: DnsLin
 * @Title: MicrosoftAuthController
 * @ProjectName: Onemanager-java
 * @Description:
 * @date: 2021/11/14 12:54
 */

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.dnslin.onemanager.logic.AuthToken;
import com.dnslin.onemanager.logic.AuthUrl;
import com.dnslin.onemanager.pojo.Onedriveconfig;
import com.dnslin.onemanager.result.R;
import com.dnslin.onemanager.result.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
@CrossOrigin
@Slf4j
public class MicrosoftAuthController {

    @Autowired
    private AuthToken authToken;

    @Autowired
    private AuthUrl authUrl;
    @Autowired
    private ServletContext context;

    @PostMapping("/MicrosoftLogin")
    public R MicrosoftLogin(Onedriveconfig config) {
        if (config != null) {
            String urlAuthUrl = authUrl.getAuthUrl(config.getClientid(), config.getClientsecret());
            try {
                authToken.getRefreshToken(config);
            } catch (IOException e) {
                log.info ("调取链接出现IO异常");
                e.printStackTrace();
            }
        }
        return new R(ResponseEnum.SUCCESS,null);
    }

    @GetMapping("/msg/inbox")
    public R getMsgInbox() {
        String url = "https://graph.microsoft.com/v1.0/me/mailfolders/inbox/messages?$select=subject,from,receivedDateTime&$top=25&$orderby=receivedDateTime%20DESC\n";


        HttpRequest get = HttpUtil.createGet(url);
        get.header(Header.CONTENT_TYPE,"Accept: application/json");
        get.header(Header.AUTHORIZATION,"Bearer "+context.getAttribute("accessToken"));

        HttpResponse execute = get.execute();
        System.out.println("execute = " + execute);
        return new R(ResponseEnum.SUCCESS,execute);
    }

}

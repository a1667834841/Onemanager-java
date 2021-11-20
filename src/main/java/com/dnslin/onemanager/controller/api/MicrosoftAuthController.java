package com.dnslin.onemanager.controller.api;

/**
 * @author: DnsLin
 * @Title: MicrosoftAuthController
 * @ProjectName: Onemanager-java
 * @Description:
 * @date: 2021/11/14 12:54
 */

import com.dnslin.onemanager.logic.AuthToken;
import com.dnslin.onemanager.logic.AuthUrl;
import com.dnslin.onemanager.pojo.Onedriveconfig;
import com.dnslin.onemanager.result.R;
import com.dnslin.onemanager.result.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/api")
@CrossOrigin
@Slf4j
public class MicrosoftAuthController {

    @Autowired
    private AuthToken authToken;

    @Autowired
    private AuthUrl authUrl;

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
}

package com.zhu.onemanager.controller;

import cn.hutool.http.HttpUtil;
import com.zhu.onemanager.controller.api.CallbackController;
import com.zhu.onemanager.logic.AuthUrl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CallbackControllerTest {

    @Resource
    private AuthUrl authUrl;
    @Resource
    private CallbackController callbackController;
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private HttpServletResponse httpServletResponse;

    @Value("${onedrive.clientId}")
    String clientId;
    @Value("${onedrive.clientSecret}")
    String clientSecret;
    @Value("${onedrive.redirectUri}")
    String redirectUri;
    @Value("${onedrive.scope}")
    String scope;





    @Test
    public void authCallback() {
        String url = "https://login.microsoftonline.com/common/oauth2/authorize?response_type=code&client_id=0d5e84db-18cf-4ab7-bc67-4af2dc9bce6b&redirect_uri=http://localhost:8081/api/outlook";
        String res = HttpUtil.get(url);
        //System.out.println("res = " + res);

    }

    @Test
    public void outlookCallback() {
    }
}
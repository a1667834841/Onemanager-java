package com.zhu.onemanager.test;

import cn.hutool.core.util.RandomUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class Test01 {
    @Test
    public void test(){
//        System.out.println("test run .....");
//        Map<String, String> map = new HashMap<>();
//        map.put("foo", "bar");
//        HttpClientResult httpClientResult = HttpUtils.doGet("https://baidu.com",map);
//        System.out.println(httpClientResult.getContent());
//        System.out.println(httpClientResult.getCode());
    }

    @Test
    public void test01(){
        String clientId = "2ddd8ff9-1137-407b-91a0-58c4dc661968";
        String redirectUri = "http://localhost:5678/api/auth";
        String state = RandomUtil.randomString(5);
        String url = String.format("https://login.microsoftonline.com/common/oauth2/v2.0/authorize?" +
                "client_id=%s" +
                "&response_type=code" +
                "&redirect_uri=%s" +
                "&response_mode=query" +
                "&scope=files.readwrite.all files.readwrite offline_access" +
                "&state=%s", clientId, redirectUri, state);
        System.out.println(url);
    }
}

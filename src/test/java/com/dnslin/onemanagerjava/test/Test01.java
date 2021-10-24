package com.dnslin.onemanagerjava.test;

import com.dnslin.onemanagerjava.utils.HttpClientUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class Test01 {
    @Test
    public void test(){
        System.out.println("test run .....");
        HttpClientUtils.doGet("https://baidu.com");
    }
}

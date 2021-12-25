package com.zhu.onemanager.pojo;

import lombok.Data;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "onedrive.file")
public class OnedriveConfig {

    private String clientId;

    private String redirectUri;

    private String clientSecret;

    private String accessToken;

    private String refreshToken;

    private Long expires;

    private String scope;

}
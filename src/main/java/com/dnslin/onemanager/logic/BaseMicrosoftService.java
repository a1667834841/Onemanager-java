package com.dnslin.onemanager.logic;

import com.dnslin.onemanager.pojo.Onedriveconfig;

public interface BaseMicrosoftService {

    Onedriveconfig getToken(String code);
}

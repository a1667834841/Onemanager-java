package com.zhu.onemanager.logic;

import com.zhu.onemanager.pojo.OnedriveConfig;

public interface BaseMicrosoftService {

    OnedriveConfig getOutlookToken(String code);
    OnedriveConfig getFileToken(String code);
}

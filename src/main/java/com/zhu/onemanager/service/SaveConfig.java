package com.zhu.onemanager.service;/**
 * @author: DnsLin
 * @Title: SaveConfig
 * @ProjectName: Onemanager-java
 * @Description:
 * @date: 2021/10/31 18:26
 */

import com.zhu.onemanager.pojo.OnedriveConfig;

/**
 * @author: DnsLin
 * @Title: SaveConfig
 * @ProjectName: Onemanager-java
 * @Description:
 * @date: 2021/10/31 18:26
 */
public interface SaveConfig {
    /**
    *
     * @Description: 保存配置到数据库
     * @param: config
     * @return int
     * @author DnsLin
     * @date 2021/10/31 18:27
    */
    void saveOnedriveConfig(OnedriveConfig config);
}

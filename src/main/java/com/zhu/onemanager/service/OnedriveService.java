package com.zhu.onemanager.service;

import com.zhu.onemanager.result.R;

public interface OnedriveService {


    /**
     * @Author ggball
     * @Description 获取获取当前用户根路径下的文件信息
     * @Date  2021/12/17
     * @Param []
     * @return com.dnslin.onemanager.result.R
     **/
    R getCurrentDriveInfo(String path);

    /**
     * @Author ggball
     * @Description 返回该项目下的子集
     * @Date  2021/12/20
     * @Param [path]
     * @return com.zhu.onemanager.result.R
     **/
    R children(String path);
}

package com.zhu.onemanager.service;

import com.zhu.onemanager.pojo.OneDriveUploadItem;
import com.zhu.onemanager.result.R;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
    R children(String formatPath, String itemId);

    /**
     * @Author ggball
     * @Description 上传大文件
     * @Date  2022/1/6
     * @Param [uploadItem]
     * @return com.zhu.onemanager.result.R
     **/
    R uploadFile(OneDriveUploadItem uploadItem) throws IOException;


    /**
     * @Author ggball
     * @Description 上传小文件（<=4mb）
     * @Date  2022/1/6
     * @Param [uploadItem]
     * @return com.zhu.onemanager.result.R
     *
     * @param uploadItem*/
    R uploadMIniFile(OneDriveUploadItem uploadItem) throws IOException;

    /**
     * @Author ggball
     * @Description 多线程上传
     * @Date  2022/1/10
     * @Param [uploadItem]
     * @return com.zhu.onemanager.result.R
     **/
    R multiUpload(OneDriveUploadItem uploadItem) throws IOException;

    /**
     * @Author ggball
     * @Description 删除itemId集合
     * @Date  2022/1/11
     * @Param [itemIds]
     * @return com.zhu.onemanager.result.R
     **/
    R deleteItem(List<String> itemIds);
}

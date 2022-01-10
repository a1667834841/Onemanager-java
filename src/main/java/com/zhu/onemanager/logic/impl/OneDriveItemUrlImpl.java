package com.zhu.onemanager.logic.impl;

import cn.hutool.core.lang.Dict;
import com.zhu.onemanager.pojo.OneDriveUploadItem;
import com.zhu.onemanager.utlis.GHttpUtil;
import com.zhu.onemanager.utlis.lang.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName FileUrlImpl.java
 * @Description TODO
 * @createTime 2022年01月05日 17:06:00
 */
@Service
public class OneDriveItemUrlImpl {

    @Value("${microsoft-graph.root-url}")
    String rootUrl;

    /**
     * @Author ggball
     * @Description 获取大文件会话
     * @Date  2022/1/5
     * @Param [driveId, itemId]
     * @return java.lang.String
     **/
    public String createUploadSession(OneDriveUploadItem uploadItem) {
        String url = "/drives/%s/items/%s:/%s:/createUploadSession";
        return String.format(url,uploadItem.getDriveId(),uploadItem.getItemId(),uploadItem.getFileName());
    }

    /**
     * @Author ggball
     * @Description 获取大文件会话
     * @Date  2022/1/5
     * @Param [driveId, itemId]
     * @return java.lang.String
     **/
    public String createCurUploadSession(OneDriveUploadItem uploadItem) {
        String url = "/me/drive/items/%s:/%s:/createUploadSession";
        return String.format(url,uploadItem.getItemId(),uploadItem.getFileName());
    }

    /**
     * @Author ggball
     * @Description 获取大文件上传url
     * @Date  2022/1/6
     * @Param [itemId, fileName]
     * @return java.lang.String
     **/
    public String getUploadUrl(OneDriveUploadItem uploadItem) {
        String uploadSessionUrl = createCurUploadSession(uploadItem);
        HashMap<String, String> parameter = new HashMap<>();
        Dict dict = GHttpUtil.postResDict(rootUrl + uploadSessionUrl, String.valueOf(parameter));
        return dict.getStr("uploadUrl");
    }

    /**
     * 获取小文件上传urL
     * @param uploadItem
     * @return
     */
    public String getMiniUploadUrl(OneDriveUploadItem uploadItem) {
        String url = "/drives/{drive-id}/items/{parent-id}:/{filename}:/content";
        return rootUrl + Strings.solve(url,uploadItem.getDriveId(),uploadItem.getItemId(),uploadItem.getFileName());
    }

    /**
     * 获取当前驱动器小文件上传urL
     * @param uploadItem
     * @return
     */
    public String getCurMiniUploadUrl(OneDriveUploadItem uploadItem) {
        String url = "/me/drive/items/{parent-id}:/{filename}:/content";
        return rootUrl + Strings.solve(url,uploadItem.getItemId(),uploadItem.getFileName());
    }

}

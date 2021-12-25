package com.zhu.onemanager.pojo;

import cn.hutool.core.lang.Dict;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.zhu.onemanager.constant.ItemConstant;
import lombok.Data;

import java.util.Date;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName DriveItem.java
 * @Description TODO
 * @createTime 2021年12月17日 17:52:00
 */
@Data
public class DriveItem {


    /**
     * 驱动器唯一标识符。只读。
     */
    private String id;

    /**
     * 上次修改项目的日期和时间。只读。
     */
    private Date lastModifiedDateTime;

    /**
     * 上次修改项目的日期和时间。只读。
     */
    private Date createdDateTime;

    /**
     * 上次修改项目的用户、设备和应用程序的标识。只读。
     */
    private JSONObject lastModifiedBy;

    /**
     * 上项目名称。读写。
     */
    private String name;

    /**
     * 项目大小，以字节为单位。只读。
     */
    private Long size;

    /**
     * 父信息（如果此项具有父级）。读写。
     */
    private JSONObject parentReference;

    /**
     * 文件信息
     */
    private File file;

    /**
     * 文件夹信息
     */
    private Folder folder;

    /**
     * item类型: {@link com.zhu.onemanager.constant.ItemConstant}
     */
//    private String itemType;

    /**
     *下载url
     */
    private String downloadUrl;

    /**
     *缩略图列表
     */
    private JSONArray thumbnails;

    /**
     *缩略图（中）
     */
    public String getThumbnail() {
        if (null != thumbnails && thumbnails.size() > 0) {
            JSONObject thumbnailJson = (JSONObject)thumbnails.get(0);
            JSONObject mediumImg = (JSONObject)thumbnailJson.get("medium");
            return mediumImg.getString("url");
        }
        return null;
    }



    @JSONField(name = "@microsoft.graph.downloadUrl")
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    /**
     * 获取当前path
     * @return
     */
    public String getPath() {
        return parentReference.getString("path");
    }

    /**
     * item类型: {@link com.zhu.onemanager.constant.ItemConstant}
     */
    public String getItemType() {
        if (null != file) {
            return ItemConstant.FILE;
        }
        if (null != folder) {
            return ItemConstant.FOLDER;
        }
        return null;
    }

}

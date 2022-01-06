package com.zhu.onemanager.pojo;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName OneDriveUploadItem.java
 * @Description onedrive 上传对象
 * @createTime 2022年01月06日 23:43:00
 */
@Data
@Builder
public class OneDriveUploadItem implements UploadItem{

    /**
     * 驱动器id
     */
    private String driveId;

    /**
     * driveItem id
     */
    private String itemId;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件大小
     */
    private String size;

    /**
     * 文件
     */
    private MultipartFile file;



    @Override
    public String getUploadUrl() {
        return null;
    }
}

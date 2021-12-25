package com.zhu.onemanager.pojo;

import lombok.Data;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName DriveParams.java
 * @Description 传参
 * @createTime 2021年12月25日 23:10:00
 */
@Data
public class DriveParams {

    /**
     * 是否展示缩略图
     */
    private boolean thumbnail;


    public String getUrl() {
        StringBuilder params = new StringBuilder();
        params.append("?$expand=");
        if (thumbnail) {
            params.append("thumbnails");
        }
        return params.toString();
    }
}

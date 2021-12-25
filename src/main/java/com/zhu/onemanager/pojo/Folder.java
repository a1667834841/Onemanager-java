package com.zhu.onemanager.pojo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName Folder.java
 * @Description TODO
 * @createTime 2021年12月20日 14:25:00
 */
@Data
public class Folder implements Serializable {

    /**
     *此容器包含的直接子项数量。
     */
    private Integer childCount;

    /**
     * 用于定义文件夹的推荐视图的属性集合。
     */
    private JSONObject view;
}

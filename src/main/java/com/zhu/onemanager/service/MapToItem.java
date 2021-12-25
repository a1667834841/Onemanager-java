package com.zhu.onemanager.service;

import com.alibaba.fastjson.JSONArray;
import com.zhu.onemanager.pojo.DriveItem;

import java.util.Map;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName MapToDriveItem.java
 * @Description TODO
 * @createTime 2021年12月25日 22:44:00
 */
public interface MapToItem {

    DriveItem toDriveItem(JSONArray array);
}

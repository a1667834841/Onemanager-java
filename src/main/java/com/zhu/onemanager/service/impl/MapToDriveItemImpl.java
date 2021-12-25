package com.zhu.onemanager.service.impl;

import cn.hutool.core.lang.Dict;
import com.alibaba.fastjson.JSONArray;
import com.zhu.onemanager.constant.ItemConstant;
import com.zhu.onemanager.pojo.DriveItem;
import com.zhu.onemanager.service.MapToItem;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName MapToDriveItemImpl.java
 * @Description TODO
 * @createTime 2021年12月25日 22:44:00
 */
public class MapToDriveItemImpl implements MapToItem {
    @Override
    public DriveItem toDriveItem(JSONArray array) {
        List<DriveItem> driveItems = new LinkedList<>();
        for (Object o : array) {
            DriveItem driveItem = new DriveItem();
            Dict itemDict = Dict.of(o);
            driveItem.setCreatedDateTime(itemDict.getDate("createdDateTime"));
            driveItem.setLastModifiedDateTime(itemDict.getDate("lastModifiedDateTime"));
            driveItem.setDownloadUrl(itemDict.getStr("downloadUrl"));
            driveItem.setId(itemDict.getStr("id"));
            driveItem.setName(itemDict.getStr("name"));
            // 判断item类型
            Object file = itemDict.get("file");
            Object folder = itemDict.get("folder");
//            if (null != file) {
//                driveItem.setItemType(ItemConstant.FILE);
//            }
//            if (null != folder) {
//                driveItem.setItemType(ItemConstant.FOLDER);
//            }

            itemDict.set("createdDateTime",itemDict.getStr("createdDateTime"));
            itemDict.set("createdDateTime",itemDict.getStr("createdDateTime"));
            itemDict.set("createdDateTime",itemDict.getStr("createdDateTime"));
        }
        return null;
    }
}

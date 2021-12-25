package com.zhu.onemanager.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.zhu.onemanager.constant.FileConstant;
import com.zhu.onemanager.pojo.DriveItem;
import com.zhu.onemanager.result.R;
import com.zhu.onemanager.service.OnedriveService;
import com.zhu.onemanager.utlis.GHttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName OnedriveServiceImpl.java
 * @Description TODO
 * @createTime 2021年12月17日 13:21:00
 */
@Service
public class OnedriveServiceImpl implements OnedriveService {

    @Value("${microsoft-graph.root-url}")
    String rootUrl;


    /**
     * @Author ggball
     * @Description 获取获取当前用户根路径下的文件信息
     * @Date  2021/12/17
     * @Param []
     * @return com.dnslin.onemanager.result.R
     **/
    @Override
    public R getCurrentDriveInfo(String path) {
        Map map = GHttpUtil.getMap(rootUrl + FileConstant.PATH_SEPARATOR + path);
        JSONArray value = (JSONArray)map.get("value");
        List<DriveItem> driveItemList = value.toJavaList(DriveItem.class);
        return R.ok(driveItemList);
    }

    @Override
    public R children(String path) {
        Map map = GHttpUtil.getMap(rootUrl + FileConstant.PATH_SEPARATOR + path);
        JSONArray value = (JSONArray)map.get("value");
        List<DriveItem> driveItemList = value.toJavaList(DriveItem.class);
        return R.ok(driveItemList);
    }
}

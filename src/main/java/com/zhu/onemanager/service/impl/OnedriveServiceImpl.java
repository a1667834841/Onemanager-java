package com.zhu.onemanager.service.impl;

import cn.hutool.core.lang.Dict;
import com.alibaba.fastjson.JSONArray;
import com.zhu.onemanager.constant.FileConstant;
import com.zhu.onemanager.logic.impl.OneDriveItemUrlImpl;
import com.zhu.onemanager.pojo.DriveItem;
import com.zhu.onemanager.pojo.OneDriveUploadItem;
import com.zhu.onemanager.pojo.vo.ItemListVO;
import com.zhu.onemanager.result.R;
import com.zhu.onemanager.service.OnedriveService;
import com.zhu.onemanager.utlis.GHttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
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
@Slf4j
public class OnedriveServiceImpl implements OnedriveService {

    @Value("${microsoft-graph.root-url}")
    String rootUrl;
    @Resource
    OneDriveItemUrlImpl oneDriveItemUrl;


    /**
     * @Author ggball
     * @Description 获取获取当前用户根路径下的文件信息
     * @Date  2021/12/17
     * @Param []
     * @return com.dnslin.onemanager.result.R
     **/
    @Override
    public R getCurrentDriveInfo(String path) {
        Map map = GHttpUtil.getResMap(rootUrl + FileConstant.PATH_SEPARATOR + path);
        JSONArray value = (JSONArray)map.get("value");
        List<DriveItem> driveItemList = value.toJavaList(DriveItem.class);
        ItemListVO itemListVO = new ItemListVO();
        itemListVO.setItemList(driveItemList);
        itemListVO.setCurItemId(driveItemList.get(0).getParentId());
        return R.ok(itemListVO);
    }

    @Override
    public R children(String formatPath, String itemId) {
        Map map = GHttpUtil.getResMap(rootUrl + FileConstant.PATH_SEPARATOR + formatPath);
        JSONArray value = (JSONArray)map.get("value");
        List<DriveItem> driveItemList = value.toJavaList(DriveItem.class);
        ItemListVO itemListVO = new ItemListVO();
        itemListVO.setItemList(driveItemList);
        itemListVO.setCurItemId(itemId);
        return R.ok(itemListVO);
    }

    /**
     * @param file
     * @return com.zhu.onemanager.result.R
     * @Author ggball
     * @Description 上传文件
     * @Date 2022/1/6
     * @Param [file]
     */
    @Override
    public R uploadFile(File file) {
        return null;
    }

    /**
     * @param uploadItem
     * @return com.zhu.onemanager.result.R
     * @Author ggball
     * @Description 上传小文件（<=4mb）
     * @Date 2022/1/6
     * @Param [uploadItem]
     */
    @Override
    public R uploadMIniFile(OneDriveUploadItem uploadItem) throws IOException {
        String url = oneDriveItemUrl.getCurMiniUploadUrl(uploadItem);
        Dict res = GHttpUtil.put(url, uploadItem.getFile().getBytes(), "text/plain");
        log.info("res:{}",res);
        return R.ok(res);
    }
}

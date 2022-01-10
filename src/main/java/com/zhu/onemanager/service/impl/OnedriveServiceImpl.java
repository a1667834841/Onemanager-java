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
import com.zhu.onemanager.utlis.FileUtils;
import com.zhu.onemanager.utlis.GHttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
     * @param uploadItem
     * @return com.zhu.onemanager.result.R
     * @Author ggball
     * @Description 上传文件
     * @Date 2022/1/6
     * @Param [file]
     */
    @Override
    public R uploadFile(OneDriveUploadItem uploadItem) throws IOException {

        // 获取上传大文件url
        String curUploadSession = oneDriveItemUrl.getUploadUrl(uploadItem);

        MultipartFile file = uploadItem.getFile();

        // 文件字节
        byte[] fileBytes = file.getBytes();

        // 客户端告诉服务端传输的文件类型
        String contentType = file.getContentType();

        // 此次传输的文件长度
        int contentLength = fileBytes.length;

        // [0] 起始位置 [1] 结束位置
        int[] range = {0,contentLength-1};

        // 文件总长度
        long totalLength = file.getSize();

        // 调用上传接口
        Dict res = GHttpUtil.put(curUploadSession, fileBytes, contentType, contentLength, totalLength, range);

        return R.ok(res);
    }

    public R multiUpload(OneDriveUploadItem uploadItem) throws IOException {
        // 初始化线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MultipartFile file = uploadItem.getFile();
        byte[] bytes = file.getBytes();
        Map<int[], byte[]> byteMap = FileUtils.fragFile(bytes);

        // 获取上传大文件url
        String curUploadSession = oneDriveItemUrl.getUploadUrl(uploadItem);
        // 文件字节
        byte[] fileBytes = file.getBytes();
        // 客户端告诉服务端传输的文件类型
        String contentType = file.getContentType();
        // 文件总长度
        long totalLength = file.getSize();

        for (Map.Entry<int[], byte[]> entry : byteMap.entrySet()) {
            // 数据范围 [0] 起始位置 [1] 结束位置
            int[] range = entry.getKey();
            // 数据
            byte[] values = entry.getValue();
            // 此次传输的文件长度
            int contentLength = values.length;

            System.out.println("range[0] = " + range[0] + "range[1] =" + range[1]);
            // 调用上传接口
            Dict res = GHttpUtil.put(curUploadSession, fileBytes, contentType, contentLength, totalLength, range);
        }

        return R.ok(null);
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

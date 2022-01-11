package com.zhu.onemanager.controller.onedrive;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.stream.CollectorUtil;
import com.zhu.onemanager.constant.FileConstant;
import com.zhu.onemanager.logic.impl.OneDriveItemUrlImpl;
import com.zhu.onemanager.pojo.DriveParams;
import com.zhu.onemanager.pojo.OneDriveUploadItem;
import com.zhu.onemanager.result.R;
import com.zhu.onemanager.service.OnedriveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName OnedriveController.java
 * @Description TODO
 * @createTime 2021年12月17日 13:15:00
 */
@RestController
@RequestMapping("/oneDrive")
@CrossOrigin
@Slf4j
public class OnedriveController {

    @Resource
    private OnedriveService onedriveService;
    @Resource
    private OneDriveItemUrlImpl oneDriveItemUrl;

    /**
     * @Author ggball
     * @Description 获取获取当前用户根路径下的文件信息
     * @Date  2021/12/17
     * @Param []
     * @return com.dnslin.onemanager.result.R
     **/
    @GetMapping("/index")
    public R getCurrentDriveInfo(DriveParams driveParams) {

        String path = "me/drive/root/children" + driveParams.getUrl();
        R r = onedriveService.getCurrentDriveInfo(path);
        return r;
    }

    @GetMapping("/{itemId}/children")
    public R children(@PathVariable("itemId") String itemId,DriveParams driveParams) {
        log.info("itemId:{}",itemId);
        String path = "me/drive/items/%s/children"+driveParams.getUrl();
        String formatPath = String.format(path,itemId);
        R r = onedriveService.children(formatPath,itemId);
        return r;

    }

    /**
     * @Author ggball
     * @Description 创建上传会话
     * @Date  2022/1/6
     * @Param [itemId] 项目id
     * @return com.zhu.onemanager.result.R
     **/
    @GetMapping("/createSession")
    public R createSession(String itemId,String fileName) {
        OneDriveUploadItem uploadItem = OneDriveUploadItem.builder()
                .itemId(itemId)
                .fileName(fileName)
                .build();

        String uploadSession = oneDriveItemUrl.getUploadUrl(uploadItem);
        return R.ok(uploadSession);
    }



    /**
     * @Author ggball
     * @Description 创建上传会话
     * @Date  2022/1/6
     * @Param [itemId] 项目id
     * @return com.zhu.onemanager.result.R
     **/
    @PostMapping("/upload")
    public R uploadItem(@RequestParam("file") MultipartFile file,String itemId) throws IOException, InterruptedException {
        if (file.isEmpty()) {
            return R.error("上传失败，请选择文件");
        }

        String fileName = file.getOriginalFilename();
        OneDriveUploadItem uploadItem = OneDriveUploadItem.builder()
                .fileName(fileName)
                .itemId(itemId)
                .file(file)
                .build();

        // 文件大于4mb ,采用大文件上传
        if (file.getSize() > (4 * FileConstant.STANDARD_MB) ) {
            return onedriveService.multiUpload(uploadItem);
        } else {
            return onedriveService.uploadMIniFile(uploadItem);
        }
    }

    @GetMapping("/delete")
    public R deleteItem(@RequestParam("itemIds") List<String> itemIds) {
        if (CollUtil.isEmpty(itemIds)) {
            return R.error("未选择删除文件");
        }

        return onedriveService.deleteItem(itemIds);
    }




}

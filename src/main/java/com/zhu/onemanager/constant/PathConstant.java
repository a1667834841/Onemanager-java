package com.zhu.onemanager.constant;

import cn.hutool.core.io.FileUtil;
import com.zhu.onemanager.utlis.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName PathConstant.java
 * @Description 路径
 * @createTime 2022年01月09日 23:01:00
 */
public class PathConstant {

    public static  String TOKEN_PATH = "token.txt";

    public static String getTokenPath() throws IOException {
        Resource resource = new ClassPathResource("token.txt");
        return resource.getFile().getAbsolutePath();
    }

    public static String getFilePath(String path) throws IOException {
        Resource resource = new ClassPathResource(path);
        return resource.getFile().getAbsolutePath();
    }

}

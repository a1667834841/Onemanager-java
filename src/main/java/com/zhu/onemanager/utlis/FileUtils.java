package com.zhu.onemanager.utlis;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import com.zhu.onemanager.constant.FileConstant;
import com.zhu.onemanager.constant.PathConstant;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.soap.SAAJResult;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName FileUtils.java
 * @Description TODO
 * @createTime 2021年12月17日 17:51:00
 */
public class FileUtils {

    /**
     *  Microsoft Graph indicates all chunks MUST be in a multiple of 320Kib (327,680 bytes).
     */
    private static final Integer FRAG_SIZE = 192 * 320 * FileConstant.STANDARD_KB;

    /**
     * @Author ggball
     * @Description map 写入对应文件路径
     * @Date  2022/1/9
     * @Param [map, path]
     * @return void
     **/
    public static void write(Map map , String path) throws IOException {
        File file = FileUtil.file(PathConstant.getFilePath(path));
        if (FileUtil.exist(file)) {
            // 文件清空
           FileUtil.writeUtf8String("",file);
        }
        // 文件写入
        FileUtil.writeUtf8Map(map,file, FileConstant.KV_SEPARATOR,false);
    }

    /**
     * @Author ggball
     * @Description 读取文件 返回map
     * @Date  2022/1/11
     * @Param [path, separator]
     * @return java.util.Map
     **/
    public static Map readMap(String path,String separator) throws IOException {
        File file = FileUtil.file(PathConstant.getFilePath(path));

        if (!FileUtil.exist(file)) {
            throw new IOException("文件找不到");
        }

        Map<String, String> map = new HashMap<>();
        List<String> lines = FileUtil.readUtf8Lines(file);

        for (String line : lines) {
            String[] split = line.split(separator);
            map.put(split[0],split[1]);
        }
        return map;

    }


    /**
     * @Author ggball
     * @Description bytes 数据拆分
     * @Date  2022/1/10
     * @Param [values]
     * @return java.util.Map<int[],byte[]> key=下标范围，value=字节
     **/
    public static Map<int[],byte[]> fragFile(byte[] values) {

        // 字节map
        Map<int[],byte[]> bytes = new LinkedHashMap<>();
        // 字节数组
        byte[] newBytes = new byte[FRAG_SIZE];
        // 最后一部分的初始下标
        int lastIndex = values.length;
        //
        int preIndex = 0;

        for (int i = 0; i < values.length; i++) {

            // 下标处于最后一部分
            if (i > 0 && i > values.length / FRAG_SIZE * FRAG_SIZE) {
                lastIndex = i-1;
                break;
            }

            // 添加字节
            newBytes[i % FRAG_SIZE] = values[i];

            // 下标是FRAG_SIZE的倍数
            if ((i+1) / FRAG_SIZE > 0 && (i+1) % FRAG_SIZE == 0) {
                // 添加字节数组
                bytes.put(new int[]{preIndex,i},newBytes.clone());
                // 重置
                newBytes = new byte[FRAG_SIZE];
                preIndex = i+1;
                continue;
            }


        }

        // 添加最后一部分
        if (values.length - lastIndex != 0) {
            byte[] lastBytes = new byte[values.length - lastIndex];
            for (int i = lastIndex; i < values.length; i++) {
                lastBytes[i % FRAG_SIZE] = values[i];
            }
            // 添加字节数组
            bytes.put(new int[]{preIndex,values.length-1},lastBytes);
        }


        return bytes;
    }

    public static void main(String[] args) {
        byte[] bytes = new byte[5 * 4 + 3];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) i;
        }

        Map<int[],byte[]> fragFile = fragFile(bytes);
        // 初始化线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);


        for (Map.Entry<int[], byte[]> entry : fragFile.entrySet()) {
            executorService.submit(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {

                    int[] key = entry.getKey();
                    System.out.println("key[0]  = " + key[0] + "key[1]  = " + key[1]);
                    byte[] value = entry.getValue();
                    System.out.println("value = " + value.toString());
                }
            });
        }

        executorService.shutdown();


    }

}

package com.zhu.onemanager.pojo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName File.java
 * @Description TODO
 * @createTime 2021年12月20日 14:22:00
 */
@Data
public class File implements Serializable {

    /**
     * 文件的 MIME 类型。这由服务器上的逻辑决定，不能是在上载文件时提供的值。只读。
     */
    private String mimeType;

    /**
     * 文件的 MIME 类型。这由服务器上的逻辑决定，不能是在上载文件时提供的值。只读。
     */
    private JSONObject hashes;

    /**
     * 文件的 MIME 类型。这由服务器上的逻辑决定，不能是在上载文件时提供的值。只读。
     */
    private Boolean processingMetadata;
}

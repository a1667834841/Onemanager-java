package com.zhu.onemanager.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName ItemList.java
 * @Description 项目列表
 * @createTime 2022年01月07日 02:03:00
 */
@Data
public class ItemListVO implements Serializable {

    /**
     * 当前项目id
     */
    private String curItemId;

    /**
     * 项目列表
     */
    private List  itemList;
}

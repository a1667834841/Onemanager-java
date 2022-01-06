package com.zhu.onemanager.handler;

import com.zhu.onemanager.pojo.Item;

/**
 * 文件处理器
 * @author ggball
 */
public interface ItemHandler {

    /**
     * @Author ggball
     * @Description 文件类型
     * @Date  2022/1/5
     * @Param []
     * @return java.lang.String
     **/
    String getType();

    /**
     * @Author ggball
     * @Description 文件变动
     * @Date  2022/1/5
     * @Param item 项目
     * @return void
     **/
    void change(Item item);


    /**
     * @Author ggball
     * @Description 文件变动后置处理
     * @Date  2022/1/5
     * @Param oldItem 旧项目
     * @Param newItem 新项目
     * @return void
     **/
    void changeCallBack(Item oldItem,Item newItem);
}

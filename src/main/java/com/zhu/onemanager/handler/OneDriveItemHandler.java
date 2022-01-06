package com.zhu.onemanager.handler;

import com.zhu.onemanager.pojo.Item;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName OneDriveFileHandler.java
 * @Description TODO
 * @createTime 2022年01月05日 17:20:00
 */
public class OneDriveItemHandler extends ItemHandlerAbs {


    /**
     * @return java.lang.String
     * @Author ggball
     * @Description 文件类型
     * @Date 2022/1/5
     * @Param []
     **/
    @Override
    public String getType() {
        return null;
    }

    /**
     * @param item
     * @return void
     * @Author ggball
     * @Description 文件变动
     * @Date 2022/1/5
     * @Param []
     */
    @Override
    public void change(Item item) {

    }

    /**
     * @param oldItem
     * @param newItem
     * @return void
     * @Author ggball
     * @Description 文件变动后置处理
     * @Date 2022/1/5
     * @Param []
     */
    @Override
    public void changeCallBack(Item oldItem, Item newItem) {

    }

    /**
     * 上传
     *
     * @param item
     */
    @Override
    public void upload(Item item) {

    }

    /**
     * 删除
     *
     * @param item
     */
    @Override
    public void delete(Item item) {

    }

    /**
     * 更新
     *
     * @param item
     */
    @Override
    public void update(Item item) {

    }

    /**
     * 查看
     *
     * @param id
     * @return
     */
    @Override
    public Item Check(String id) {
        return null;
    }
}

package com.zhu.onemanager.handler;

import com.zhu.onemanager.pojo.Item;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName FileHandlerAbs.java
 * @Description TODO
 * @createTime 2022年01月05日 17:19:00
 */
public abstract class ItemHandlerAbs implements ItemHandler {

    /**
     * 上传
     * @param item
     */
    public abstract void upload(Item item);

    /**
     * 删除
     * @param item
     */
    public abstract void delete(Item item);

    /**
     * 更新
     * @param item
     */
    public abstract void update(Item item);

    /**
     * 查看
     * @param id
     * @return
     */
    public abstract Item Check(String id);
}

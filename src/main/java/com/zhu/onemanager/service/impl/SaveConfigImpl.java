package com.zhu.onemanager.service.impl;/**
 * @author: DnsLin
 * @Title: SaveConfigImpl
 * @ProjectName: Onemanager-java
 * @Description:
 * @date: 2021/10/31 18:28
 */

import com.zhu.onemanager.exception.AppException;
import com.zhu.onemanager.mapper.OnedriveconfigMapper;
import com.zhu.onemanager.pojo.OnedriveConfig;
import com.zhu.onemanager.result.ResponseEnum;
import com.zhu.onemanager.service.SaveConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SaveConfigImpl implements SaveConfig {
    @Autowired
    private OnedriveconfigMapper onedriveconfigMapper;

    @Override
    @Transactional
    public void saveOnedriveConfig(OnedriveConfig config) {
        if (config == null) {
            throw new AppException(ResponseEnum.OBJECT_IS_EMPTY);
        }
        // 当clientId存在时候 为更新数据 不存在就插入
        OnedriveConfig onedriveconfig = onedriveconfigMapper.selectByPrimaryKey(config.getClientId());
        if (onedriveconfig == null) {
            int state = onedriveconfigMapper.insertSelective(config);
            if (state < 1) {
                throw new AppException(ResponseEnum.INSERT_THE_FAILURE);
            }
        }else {
            onedriveconfigMapper.updateByPrimaryKey(config);
        }

    }
}

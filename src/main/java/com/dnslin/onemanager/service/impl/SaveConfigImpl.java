package com.dnslin.onemanager.service.impl;/**
 * @author: DnsLin
 * @Title: SaveConfigImpl
 * @ProjectName: Onemanager-java
 * @Description:
 * @date: 2021/10/31 18:28
 */

import com.dnslin.onemanager.exception.AppException;
import com.dnslin.onemanager.mapper.OnedriveconfigMapper;
import com.dnslin.onemanager.pojo.Onedriveconfig;
import com.dnslin.onemanager.result.ResponseEnum;
import com.dnslin.onemanager.service.SaveConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SaveConfigImpl implements SaveConfig {
    @Autowired
    private OnedriveconfigMapper onedriveconfigMapper;

    @Override
    @Transactional
    public void saveOnedriveConfig(Onedriveconfig config) {
        if (config == null) {
            throw new AppException(ResponseEnum.OBJECT_IS_EMPTY);
        }
        // 当clientId存在时候 为更新数据 不存在就插入
        Onedriveconfig onedriveconfig = onedriveconfigMapper.selectByPrimaryKey(config.getClientid());
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

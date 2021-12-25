package com.zhu.onemanager.mapper;

import com.zhu.onemanager.pojo.OnedriveConfig;
import com.zhu.onemanager.pojo.OnedriveconfigExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OnedriveconfigMapper {
    int countByExample(OnedriveconfigExample example);

    int deleteByExample(OnedriveconfigExample example);

    int deleteByPrimaryKey(String clientid);

    int insert(OnedriveConfig record);

    int insertSelective(OnedriveConfig record);

    List<OnedriveConfig> selectByExample(OnedriveconfigExample example);

    OnedriveConfig selectByPrimaryKey(String clientid);

    int updateByExampleSelective(@Param("record") OnedriveConfig record, @Param("example") OnedriveconfigExample example);

    int updateByExample(@Param("record") OnedriveConfig record, @Param("example") OnedriveconfigExample example);

    int updateByPrimaryKeySelective(OnedriveConfig record);

    int updateByPrimaryKey(OnedriveConfig record);
}
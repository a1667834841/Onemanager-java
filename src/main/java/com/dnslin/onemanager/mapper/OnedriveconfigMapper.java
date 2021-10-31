package com.dnslin.onemanager.mapper;

import com.dnslin.onemanager.pojo.Onedriveconfig;
import com.dnslin.onemanager.pojo.OnedriveconfigExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OnedriveconfigMapper {
    int countByExample(OnedriveconfigExample example);

    int deleteByExample(OnedriveconfigExample example);

    int deleteByPrimaryKey(String clientid);

    int insert(Onedriveconfig record);

    int insertSelective(Onedriveconfig record);

    List<Onedriveconfig> selectByExample(OnedriveconfigExample example);

    Onedriveconfig selectByPrimaryKey(String clientid);

    int updateByExampleSelective(@Param("record") Onedriveconfig record, @Param("example") OnedriveconfigExample example);

    int updateByExample(@Param("record") Onedriveconfig record, @Param("example") OnedriveconfigExample example);

    int updateByPrimaryKeySelective(Onedriveconfig record);

    int updateByPrimaryKey(Onedriveconfig record);
}
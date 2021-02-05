package com.sershare.asset.data.standard.mapper;


import com.sershare.asset.data.standard.entity.EnterpriseInfo;
import org.apache.ibatis.annotations.Param;

public interface EnterpriseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnterpriseInfo record);

    int insertSelective(EnterpriseInfo record);

    EnterpriseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnterpriseInfo record);

    int updateByPrimaryKey(EnterpriseInfo record);


    EnterpriseInfo selectByCreditCode(@Param("assetId") String assetId, @Param("creditCode") String creditCode);
}
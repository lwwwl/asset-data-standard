package com.sershare.asset.data.standard.service.task;

import com.sershare.asset.data.standard.entity.EnterpriseInfo;

public interface EnterpriseInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(EnterpriseInfo record);

    int insertSelective(EnterpriseInfo record);

    EnterpriseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnterpriseInfo record);

    int updateByPrimaryKey(EnterpriseInfo record);

    EnterpriseInfo selectByCreditCode(String assetId,String creditCode);
}
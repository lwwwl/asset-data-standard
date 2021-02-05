package com.sershare.asset.data.standard.service.task;

import com.sershare.asset.data.standard.entity.GuarantyInfo;

import java.util.List;

public interface GuarantyInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(GuarantyInfo record);

    int insertSelective(GuarantyInfo record);

    GuarantyInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GuarantyInfo record);

    int updateByPrimaryKey(GuarantyInfo record);

    GuarantyInfo selectByCompositeKeys(String projectId, String assetId,String agencyId,String guarantyType,String guarantyUmber);

    List<GuarantyInfo> selectByCompositeKeysList(String projectId, String assetId, String agencyId);
}
package com.sershare.asset.data.standard.service.task;

import com.sershare.asset.data.standard.entity.AssetSupplement;

import java.util.List;

public interface AssetSupplementService {
    int deleteByPrimaryKey(Integer id);

    int insert(AssetSupplement record);

    int insertSelective(AssetSupplement record);

    AssetSupplement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssetSupplement record);

    int updateByPrimaryKey(AssetSupplement record);

    AssetSupplement selectByUnionKey( String projectId, String assetId,String agencyId,String tradedate);


    List<AssetSupplement> selectByCompositeKeys(String projectId, String assetId, String agencyId, String tradedate);

    List<AssetSupplement> selectByUpdateTime( String projectId,String date);
}
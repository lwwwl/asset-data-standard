package com.sershare.asset.data.standard.service.task;

import com.sershare.asset.data.standard.entity.AssetPayFlow;

import java.util.List;

public interface AssetPayFlowService {
    int deleteByPrimaryKey(Integer id);

    int insert(AssetPayFlow record);

    int insertSelective(AssetPayFlow record);

    AssetPayFlow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssetPayFlow record);

    int updateByPrimaryKey(AssetPayFlow record);

    List<AssetPayFlow> selectByCompositeKeys(String projectId, String assetId, String agencyId);

    AssetPayFlow selectByUnionKey(String projectId, String assetId,String agencyId,String tradeTime,String orderId);

    List<AssetPayFlow> selectByUpdateTime(String projectId, String date);

    List<AssetPayFlow> selectByTradeType(String projectId, String assetId, String agencyId, String tradeType);
}
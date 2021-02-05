package com.sershare.asset.data.standard.mapper;

import com.sershare.asset.data.standard.entity.AssetPayFlow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssetPayFlowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AssetPayFlow record);

    int insertSelective(AssetPayFlow record);

    AssetPayFlow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssetPayFlow record);

    int updateByPrimaryKey(AssetPayFlow record);

    List<AssetPayFlow> selectByCompositeKeys(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("agencyId")String agencyId);

    AssetPayFlow selectByUnionKey(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("agencyId")String agencyId,@Param("tradeTime")String tradeTime,@Param("orderId")String orderId);

    List<AssetPayFlow> selectByUpdateTime(@Param("projectId") String projectId, @Param("date")String date);

    List<AssetPayFlow> selectByTradeType(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("agencyId")String agencyId,@Param("tradeType")String tradeType);
}
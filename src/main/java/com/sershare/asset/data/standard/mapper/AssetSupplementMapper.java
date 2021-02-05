package com.sershare.asset.data.standard.mapper;

import com.sershare.asset.data.standard.entity.AssetSupplement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssetSupplementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AssetSupplement record);

    int insertSelective(AssetSupplement record);

    AssetSupplement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssetSupplement record);

    int updateByPrimaryKey(AssetSupplement record);

    AssetSupplement selectByUnionKey(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("agencyId")String agencyId, @Param("tradedate")String tradedate);

    List<AssetSupplement> selectByCompositeKeys(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("agencyId")String agencyId, @Param("tradedate") String tradedate);

    List<AssetSupplement> selectByUpdateTime(@Param("projectId") String projectId, @Param("date")String date);
}
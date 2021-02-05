package com.sershare.asset.data.standard.mapper;


import com.sershare.asset.data.standard.entity.AssetDisposal;
import org.apache.ibatis.annotations.Param;

public interface AssetDisposalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AssetDisposal record);

    int insertSelective(AssetDisposal record);

    AssetDisposal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssetDisposal record);

    int updateByPrimaryKey(AssetDisposal record);

    AssetDisposal selectByUnionKey(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("agencyId") String agencyId);
}
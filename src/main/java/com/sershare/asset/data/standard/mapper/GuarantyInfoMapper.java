package com.sershare.asset.data.standard.mapper;


import com.sershare.asset.data.standard.entity.GuarantyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GuarantyInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GuarantyInfo record);

    int insertSelective(GuarantyInfo record);

    GuarantyInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GuarantyInfo record);

    int updateByPrimaryKey(GuarantyInfo record);

    GuarantyInfo selectByCompositeKeys(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("agencyId")String agencyId,@Param("guarantyType")String guarantyType,@Param("guarantyUmber") String guarantyUmber);

    List<GuarantyInfo> selectByCompositeKeysList(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("agencyId")String agencyId);

    List<Map<String, Object>> selectExtraInfoBySign();

    int updateSignById(@Param("Id") Integer Id);

    Map<String, Object> selectExtraInfoByAssetIdAndSign(@Param("assetId") String assetId);
}
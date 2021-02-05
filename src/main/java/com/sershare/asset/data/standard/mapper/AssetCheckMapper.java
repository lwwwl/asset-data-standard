package com.sershare.asset.data.standard.mapper;


import com.sershare.asset.data.standard.entity.AssetCheck;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface AssetCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AssetCheck record);

    int insertSelective(AssetCheck record);

    AssetCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssetCheck record);

    int updateByPrimaryKey(AssetCheck record);

    AssetCheck selectLessDate(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("accountDate") Date accountDate);

    List<AssetCheck> selectOverDueList(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("assetsStatus") String assetsStatus, @Param("accountDate") Date accountDate);

    AssetCheck fingByUnion(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("accountDate") Date accountDate);

    List<AssetCheck> selectByCompositeKeys(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("agencyId") String agencyId);

    List<AssetCheck> selectByProjectIdAndAccountDate(@Param("projectId") String projectId, @Param("accountDate") Date accountDate, @Param("start") int start, @Param("end") int end);

    int countByProjectIdAndAccountDate(@Param("projectId") String projectId, @Param("accountDate") Date accountDate);

    /**
     * 根据项目编号查询
     * @param projectId 项目编号
     * @return 资产对账信息详情
     */
    List<AssetCheck> selectAssetCheckByProject(@Param("projectId") String projectId);


    void deleteByAccountDate(Map params);

    String selectMaxAccountDate(String projectId);

    String selectMaxAccountDateByAssetId(@Param("projectId") String projectId, @Param("assetId") String assetId);

    AssetCheck selectClosedAsset(@Param("projectId") String projectId, @Param("agencyId") String agencyId, @Param("assetId") String assetId, @Param("accountDate") Date accountDate, @Param("assetStatus") String assetStatus);


    List<AssetCheck> selectByKeysAndAccountDate(@Param("projectId") String projectId, @Param("agencyId") String agencyId, @Param("assetId") String assetId, @Param("accountDate") Date accountDate);

	List<AssetCheck> selectlastDayOverDueList(@Param("projectId") String projectId, @Param("accountDate") Date accountDate);

	List<AssetCheck> selectListByCondition(@Param("projectId") String projectId, @Param("accountDate") Date accountDate, @Param("assetStatus") String assetStatus);
}
package com.sershare.asset.data.standard.mapper;

import com.sershare.asset.data.standard.entity.AssetCheck;
import com.sershare.asset.data.standard.entity.AssetCheckInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AssetCheckInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AssetCheckInfo record);

    int insertSelective(AssetCheckInfo record);

    AssetCheckInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssetCheckInfo record);

    int updateByPrimaryKey(AssetCheckInfo record);

    /**
     * 根据借据号、项目号、数据提取日查找资产对账信息
     * @author v_wangpeng
     * @date 2018/12/26 17:41
     * @param assetId 资产借据号
     * @param projectId 项目编号
     * @param extractDate 数据提取日
     * @return 资产对账信息详情
     */
    AssetCheckInfo selectAssetCheckInfoByExtractDate(@Param("assetId")String assetId, @Param("projectId")String projectId, @Param("extractDate") Date extractDate);

    /**
     * 根据项目编号和不为修复的借据号查询
     * @param projectId 项目编号
     * @return 资产对账信息详情
     */
    List<AssetCheck> selectAssetCheckInfoByProject(@Param("projectId") String projectId);

}
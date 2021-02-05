package com.sershare.asset.data.standard.service.task;

import com.sershare.asset.data.standard.entity.AssetCheck;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: AssertStatusProject
 * @description: 资产对账计算信息服务类
 * @author: xiongwei.zhu
 * @create: 2018-10-25 11:18
 **/
public interface AssetCheckService {

    int deleteByPrimaryKey(Integer id);

    int insert(AssetCheck record);

    int insertSelective(AssetCheck record);

    AssetCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssetCheck record);

    int updateByPrimaryKey(AssetCheck record);

    AssetCheck selectLessDate(String projectId,   String assetId,  Date accountDate);

    List<AssetCheck> selectOverDueList(String projectId, String assetId, String assetsStatus, Date accountDate);

    AssetCheck fingByUnion( String projectId,  String assetId,  Date accountDate);

    List<AssetCheck> selectByCompositeKeys(String projectId,  String assetId,String agencyId);

    /**
     * 根据项目编号查询
     * @param projectId 项目编号
     * @return 资产对账信息详情
     */
    List<AssetCheck> selectAssetCheckByProject(String projectId);

    void deleteByAccountDate(Map params);

    String selectMaxAccountDate(String projectId);

    String selectMaxAccountDateByAssetId(String projectId, String assetId);

    AssetCheck selectClosedAsset(String projectId, String agencyId, String assetId, Date accountDate, String assetStatus);

    List<AssetCheck> selectByKeysAndAccountDate(String projectId,String agencyId, String assetId, Date accountDate);

    int countByProjectIdAndAccountDate( String projectId,  Date accountDate);

    List<AssetCheck> selectByProjectIdAndAccountDate( String projectId,  Date accountDate, int start,int end);

    /**
     * 查询accountDate 日正常  accountDate -1 逾期的数据
     * @param projectId
     * @param stringConvert2Date
     * @return
     */
    List<AssetCheck> selectlastDayOverDueList(String projectId, Date accountDate);

    List<AssetCheck> selectListByCondition(String projectId, Date stringConvert2Date, String overDueStatus);
}

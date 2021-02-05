package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.AssetCheck;
import com.sershare.asset.data.standard.mapper.AssetCheckMapper;
import com.sershare.asset.data.standard.service.task.AssetCheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: AssertStatusProject
 * @description:
 * @author: xiongwei.zhu
 * @create: 2018-10-25 11:19
 **/
@Service
public class AssetCheckServiceImpl implements AssetCheckService {

    @Resource
    AssetCheckMapper assetCheckMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return assetCheckMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AssetCheck record) {
        return assetCheckMapper.insert(record);
    }

    @Override
    public int insertSelective(AssetCheck record) {
        return assetCheckMapper.insertSelective(record);
    }

    @Override
    public AssetCheck selectByPrimaryKey(Integer id) {
        return assetCheckMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AssetCheck record) {
        return assetCheckMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AssetCheck record) {
        return assetCheckMapper.updateByPrimaryKey(record);
    }

    @Override
    public AssetCheck selectLessDate(String projectId, String assetId, Date accountDate) {
        return assetCheckMapper.selectLessDate(projectId,assetId,new java.sql.Date(accountDate.getTime()));
    }

    @Override
    public List<AssetCheck> selectOverDueList(String projectId, String assetId, String assetsStatus, Date accountDate) {
        return assetCheckMapper.selectOverDueList(projectId,assetId,assetsStatus,new java.sql.Date(accountDate.getTime()));
    }

    @Override
    public AssetCheck fingByUnion(String projectId, String assetId, Date accountDate) {
        return assetCheckMapper.fingByUnion(projectId,assetId,new java.sql.Date(accountDate.getTime()));
    }

    @Override
    public List<AssetCheck> selectByCompositeKeys(String projectId, String assetId, String agencyId) {
        return assetCheckMapper.selectByCompositeKeys(projectId,assetId,agencyId);
    }

    @Override
    public List<AssetCheck> selectAssetCheckByProject(String projectId) {
        return assetCheckMapper.selectAssetCheckByProject(projectId);
    }

    @Override
    public void deleteByAccountDate(Map params) {
        assetCheckMapper.deleteByAccountDate(params);
    }

    @Override
    public String selectMaxAccountDate(String projectId) {
        return assetCheckMapper.selectMaxAccountDate(projectId);
    }

    @Override
    public String selectMaxAccountDateByAssetId(String projectId, String assetId) {
        return assetCheckMapper.selectMaxAccountDateByAssetId(projectId,assetId);
    }

    @Override
    public AssetCheck selectClosedAsset(String projectId, String agencyId, String assetId, Date accountDate, String assetStatus) {
        return assetCheckMapper.selectClosedAsset(projectId,agencyId,assetId,new java.sql.Date(accountDate.getTime()),assetStatus);
    }

    @Override
    public List<AssetCheck> selectByKeysAndAccountDate(String projectId, String agencyId, String assetId, Date accountDate) {
        return assetCheckMapper.selectByKeysAndAccountDate(projectId,agencyId,assetId,new java.sql.Date(accountDate.getTime()));
    }

    @Override
    public int countByProjectIdAndAccountDate(String projectId, Date accountDate) {
        return assetCheckMapper.countByProjectIdAndAccountDate(projectId,new java.sql.Date(accountDate.getTime()));
    }

    @Override
    public List<AssetCheck> selectByProjectIdAndAccountDate(String projectId, Date accountDate, int start, int end) {
        return assetCheckMapper.selectByProjectIdAndAccountDate(projectId,new java.sql.Date(accountDate.getTime()),start,end);
    }

    @Override
    public List<AssetCheck> selectlastDayOverDueList(String projectId, Date accountDate) {
        return assetCheckMapper.selectlastDayOverDueList(projectId, new java.sql.Date(accountDate.getTime()));
    }

    @Override
    public List<AssetCheck> selectListByCondition(String projectId, Date accountDate, String overDueStatus) {
        return assetCheckMapper.selectListByCondition(projectId, new java.sql.Date(accountDate.getTime()), overDueStatus);
    }
}

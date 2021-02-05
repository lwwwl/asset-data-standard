package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.AssetCheck;
import com.sershare.asset.data.standard.entity.AssetCheckInfo;
import com.sershare.asset.data.standard.mapper.AssetCheckInfoMapper;
import com.sershare.asset.data.standard.service.task.AssetCheckInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: AssertStatusProject
 * @description: 资产对账原始信息服务类
 * @author: xiongwei.zhu
 * @create: 2018-10-25 11:15
 **/
@Service
public class AssetCheckInfoServiceImpl implements AssetCheckInfoService {

    @Resource
    AssetCheckInfoMapper assetCheckInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return assetCheckInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AssetCheckInfo record) {
        return assetCheckInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(AssetCheckInfo record) {
        return assetCheckInfoMapper.insertSelective(record);
    }

    @Override
    public AssetCheckInfo selectByPrimaryKey(Integer id) {
        return assetCheckInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AssetCheckInfo record) {
        return assetCheckInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AssetCheckInfo record) {
        return assetCheckInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public AssetCheckInfo selectAssetCheckInfoByExtractDate(String assetId, String projectId, Date extractDate) {
        return assetCheckInfoMapper.selectAssetCheckInfoByExtractDate(assetId,projectId,extractDate);
    }

    @Override
    public List<AssetCheck> selectAssetCheckInfoByProject(String projectId) {
        return assetCheckInfoMapper.selectAssetCheckInfoByProject(projectId);
    }
}

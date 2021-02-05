package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.AssetSupplement;
import com.sershare.asset.data.standard.mapper.AssetSupplementMapper;
import com.sershare.asset.data.standard.service.task.AssetSupplementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: AssertStatusProject
 * @description: 资产补充信息服务
 * @author: xiongwei.zhu
 * @create: 2018-10-25 11:54
 **/
@Service
public class AssetSupplementServiceImpl implements AssetSupplementService {

    @Resource
    AssetSupplementMapper assetSupplementMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return assetSupplementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AssetSupplement record) {
        return assetSupplementMapper.insert(record);
    }

    @Override
    public int insertSelective(AssetSupplement record) {
        return assetSupplementMapper.insertSelective(record);
    }

    @Override
    public AssetSupplement selectByPrimaryKey(Integer id) {
        return assetSupplementMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AssetSupplement record) {
        return assetSupplementMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AssetSupplement record) {
        return assetSupplementMapper.updateByPrimaryKey(record);
    }

    @Override
    public AssetSupplement selectByUnionKey(String projectId, String assetId, String agencyId, String tradedate) {
        return assetSupplementMapper.selectByUnionKey(projectId,assetId,agencyId,tradedate);
    }

    @Override
    public List<AssetSupplement> selectByCompositeKeys(String projectId, String assetId, String agencyId, String tradedate) {
        return assetSupplementMapper.selectByCompositeKeys(projectId,assetId,agencyId, tradedate);
    }

    @Override
    public List<AssetSupplement> selectByUpdateTime(String projectId, String date) {
        return assetSupplementMapper.selectByUpdateTime(projectId,date);
    }
}

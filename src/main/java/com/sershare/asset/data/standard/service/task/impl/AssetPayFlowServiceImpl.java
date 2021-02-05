package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.AssetPayFlow;
import com.sershare.asset.data.standard.mapper.AssetPayFlowMapper;
import com.sershare.asset.data.standard.service.task.AssetPayFlowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: AssertStatusProject
 * @description: 支付流水信息
 * @author: xiongwei.zhu
 * @create: 2018-10-25 11:51
 **/
@Service
public class AssetPayFlowServiceImpl implements AssetPayFlowService {

    @Resource
    AssetPayFlowMapper assetPayFlowMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return assetPayFlowMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AssetPayFlow record) {
        return assetPayFlowMapper.insert(record);
    }

    @Override
    public int insertSelective(AssetPayFlow record) {
        return assetPayFlowMapper.insertSelective(record);
    }

    @Override
    public AssetPayFlow selectByPrimaryKey(Integer id) {
        return assetPayFlowMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AssetPayFlow record) {
        return assetPayFlowMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AssetPayFlow record) {
        return assetPayFlowMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<AssetPayFlow> selectByCompositeKeys(String projectId, String assetId, String agencyId) {
        return assetPayFlowMapper.selectByCompositeKeys(projectId,assetId,agencyId);
    }

    @Override
    public AssetPayFlow selectByUnionKey(String projectId, String assetId, String agencyId, String tradeTime,String orderId) {
        return assetPayFlowMapper.selectByUnionKey(projectId,assetId,agencyId,tradeTime,orderId);
    }

    @Override
    public List<AssetPayFlow> selectByUpdateTime(String projectId, String date) {
        return assetPayFlowMapper.selectByUpdateTime(projectId,date);
    }

    @Override
    public List<AssetPayFlow> selectByTradeType(String projectId, String assetId, String agencyId, String tradeType) {
        return assetPayFlowMapper.selectByTradeType(projectId,assetId,agencyId,tradeType);
    }
}

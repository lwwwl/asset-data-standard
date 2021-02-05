package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.AssetDisposal;
import com.sershare.asset.data.standard.mapper.AssetDisposalMapper;
import com.sershare.asset.data.standard.service.task.AssetDisposalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: AssertStatusProject
 * @description:
 * @author: xiongwei.zhu
 * @create: 2018-10-25 11:25
 **/
@Service
public class AssetDisposalServiceImpl implements AssetDisposalService {

    @Resource
    AssetDisposalMapper assetDisposalMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return assetDisposalMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AssetDisposal record) {
        return assetDisposalMapper.insert(record);
    }

    @Override
    public int insertSelective(AssetDisposal record) {
        return assetDisposalMapper.insertSelective(record);
    }

    @Override
    public AssetDisposal selectByPrimaryKey(Integer id) {
        return assetDisposalMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AssetDisposal record) {
        return assetDisposalMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AssetDisposal record) {
        return assetDisposalMapper.updateByPrimaryKey(record);
    }

    @Override
    public AssetDisposal selectByUnionKey(String projectId, String assetId, String agencyId) {
        return assetDisposalMapper.selectByUnionKey(projectId,assetId,agencyId);
    }
}

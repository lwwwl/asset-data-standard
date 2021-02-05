package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.PrincipalBorrowerInfo;
import com.sershare.asset.data.standard.mapper.PrincipalBorrowerInfoMapper;
import com.sershare.asset.data.standard.service.task.PrincipalBorrowerInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: AssertStatusProject
 * @description:
 * @author: xiongwei.zhu
 * @create: 2018-10-25 14:25
 **/
@Service
public class PrincipalBorrowerInfoServiceImpl implements PrincipalBorrowerInfoService {

    @Resource
    PrincipalBorrowerInfoMapper principalBorrowerInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return principalBorrowerInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PrincipalBorrowerInfo record) {
        return principalBorrowerInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(PrincipalBorrowerInfo record) {
        return principalBorrowerInfoMapper.insertSelective(record);
    }

    @Override
    public PrincipalBorrowerInfo selectByPrimaryKey(Integer id) {
        return principalBorrowerInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PrincipalBorrowerInfo record) {
        return principalBorrowerInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PrincipalBorrowerInfo record) {
        return principalBorrowerInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public PrincipalBorrowerInfo selectByCompositeKeys(String projectId, String assetId, String agencyId) {
        return principalBorrowerInfoMapper.selectByCompositeKeys(projectId,assetId,agencyId);
    }

    @Override
    public PrincipalBorrowerInfo selectByUnionKey(String projectId, String assetId) {
        return principalBorrowerInfoMapper.selectByUnionKey(projectId,assetId);
    }

    @Override
    public int deleteByCompositeKeys(String projectId, String agencyId, String assetId) {
        return principalBorrowerInfoMapper.deleteByCompositeKeys(projectId,agencyId,assetId);
    }

    @Override
    public List<PrincipalBorrowerInfo> selectByProject(String projectId) {
        return principalBorrowerInfoMapper.selectByProject(projectId);
    }
}

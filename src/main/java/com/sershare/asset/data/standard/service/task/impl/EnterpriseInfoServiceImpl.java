package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.EnterpriseInfo;
import com.sershare.asset.data.standard.mapper.EnterpriseInfoMapper;
import com.sershare.asset.data.standard.service.task.EnterpriseInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: AssertStatusProject
 * @description:
 * @author: xiongwei.zhu
 * @create: 2018-10-25 14:16
 **/
@Service
public class EnterpriseInfoServiceImpl implements EnterpriseInfoService {

    @Resource
    EnterpriseInfoMapper enterpriseInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return enterpriseInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(EnterpriseInfo record) {
        return enterpriseInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(EnterpriseInfo record) {
        return enterpriseInfoMapper.insertSelective(record);
    }

    @Override
    public EnterpriseInfo selectByPrimaryKey(Integer id) {
        return enterpriseInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(EnterpriseInfo record) {
        return enterpriseInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(EnterpriseInfo record) {
        return enterpriseInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public EnterpriseInfo selectByCreditCode(String assetId, String creditCode) {
        return enterpriseInfoMapper.selectByCreditCode(assetId,creditCode);
    }
}

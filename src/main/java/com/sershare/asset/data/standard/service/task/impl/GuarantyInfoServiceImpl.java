package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.GuarantyInfo;
import com.sershare.asset.data.standard.mapper.GuarantyInfoMapper;
import com.sershare.asset.data.standard.service.task.GuarantyInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: AssertStatusProject
 * @description:
 * @author: xiongwei.zhu
 * @create: 2018-10-25 14:18
 **/
@Service
public class GuarantyInfoServiceImpl implements GuarantyInfoService {

    @Resource
    GuarantyInfoMapper guarantyInfoMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return guarantyInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GuarantyInfo record) {
        return guarantyInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(GuarantyInfo record) {
        return guarantyInfoMapper.insertSelective(record);
    }

    @Override
    public GuarantyInfo selectByPrimaryKey(Integer id) {
        return guarantyInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GuarantyInfo record) {
        return guarantyInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GuarantyInfo record) {
        return guarantyInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public GuarantyInfo selectByCompositeKeys(String projectId, String assetId, String agencyId, String guarantyType,String guarantyUmber) {
        return guarantyInfoMapper.selectByCompositeKeys(projectId,assetId,agencyId,guarantyType,guarantyUmber);
    }

    @Override
    public List<GuarantyInfo> selectByCompositeKeysList(String projectId, String assetId, String agencyId) {
        return guarantyInfoMapper.selectByCompositeKeysList(projectId,assetId,agencyId);
    }
}

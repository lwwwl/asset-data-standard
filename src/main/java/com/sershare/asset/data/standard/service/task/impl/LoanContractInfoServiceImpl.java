package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.LoanContractInfo;
import com.sershare.asset.data.standard.mapper.LoanContractInfoMapper;
import com.sershare.asset.data.standard.service.task.LoanContractInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: AssertStatusProject
 * @description:
 * @author: xiongwei.zhu
 * @create: 2018-10-25 14:20
 **/
@Service
public class LoanContractInfoServiceImpl implements LoanContractInfoService {

    @Resource
    LoanContractInfoMapper loanContractInfoMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return loanContractInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(LoanContractInfo record) {
        return loanContractInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(LoanContractInfo record) {
        return loanContractInfoMapper.insertSelective(record);
    }

    @Override
    public LoanContractInfo selectByPrimaryKey(Integer id) {
        return loanContractInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(LoanContractInfo record) {
        return loanContractInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LoanContractInfo record) {
        return loanContractInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public LoanContractInfo selectByUnionKey(String projectId, String assetId) {
        return loanContractInfoMapper.selectByUnionKey(projectId,assetId);
    }

    @Override
    public LoanContractInfo selectByCompositeKeys(String projectId, String assetId, String agencyId) {
        return loanContractInfoMapper.selectByCompositeKeys(projectId,assetId,agencyId);
    }

    @Override
    public List<LoanContractInfo> selectAllData() {
        return loanContractInfoMapper.selectAllData();
    }

    @Override
    public List<LoanContractInfo> selectNormalData(String projectId, String verifyStatus) {
        return loanContractInfoMapper.selectNormalData(projectId, verifyStatus);
    }

    @Override
    public LoanContractInfo selectByProjectId(String projectId) {
        return loanContractInfoMapper.selectByProjectId(projectId);
    }

    @Override
    public List<String> findAllSerialNumberByProjectId(String projectId) {
        return loanContractInfoMapper.findAllSerialNumberByProjectId(projectId);
    }

    @Override
    public List<LoanContractInfo> selectAllAssetByProjectId(String projectId) {
        return loanContractInfoMapper.selectAllAssetByProjectId(projectId);
    }

    @Override
    public List<LoanContractInfo> selectByProjectIdAndFlag(String projectId, String absPushFlag) {
        return loanContractInfoMapper.selectByProjectIdAndFlag(projectId,absPushFlag);
    }

    @Override
    public List<LoanContractInfo> selectByKeys(String projectId, String assetId) {
        return loanContractInfoMapper.selectByKeys(projectId,assetId);
    }
}

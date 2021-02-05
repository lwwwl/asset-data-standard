package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.RepaymentInfo;
import com.sershare.asset.data.standard.mapper.RepaymentInfoMapper;
import com.sershare.asset.data.standard.service.task.RepaymentInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: AssertStatusProject
 * @description:
 * @author: xiongwei.zhu
 * @create: 2018-10-25 14:27
 **/
@Service
public class RepaymentInfoServiceImpl implements RepaymentInfoService {

    @Resource
    RepaymentInfoMapper repaymentInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return repaymentInfoMapper.deleteByPrimaryKey(id);
    }


    @Override
    public int insert(RepaymentInfo record) {
        if(record.getPeriod() != 0){
            record.calcOnPerodStatus();
        }
        return repaymentInfoMapper.insert(record);
    }


    @Override
    public int insertSelective(RepaymentInfo record) {
        if(record.getPeriod() != 0){
            record.calcOnPerodStatus();
        }
        return repaymentInfoMapper.insertSelective(record);
    }

    @Override
    public RepaymentInfo selectByPrimaryKey(Integer id) {
        return repaymentInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RepaymentInfo record) {
        if(record.getPeriod() != 0){
            record.calcOnPerodStatus();
        }
        return repaymentInfoMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public int updateByPrimaryKey(RepaymentInfo record) {
        if(record.getPeriod() != 0){
            record.calcOnPerodStatus();
        }
        return repaymentInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public RepaymentInfo selectByUnionKey(String projectId, String assetId, Date repayDate) {
        return repaymentInfoMapper.selectByUnionKey(projectId,assetId,repayDate);
    }

    @Override
    public List<RepaymentInfo> selectListByUnionKeyLessDate(String projectId, String assetId, Date statusDate) {
        return repaymentInfoMapper.selectListByUnionKeyLessDate(projectId,assetId,statusDate);
    }

    @Override
    public List<RepaymentInfo> selectAllRepaymentInfo(String projectId, String assetId) {
        return repaymentInfoMapper.selectAllRepaymentInfo(projectId,assetId);
    }

    @Override
    public List<RepaymentInfo> selectRepayInfoByLessDate(String projectId, String assetId, Date repayDate) {
        return repaymentInfoMapper.selectRepayInfoByLessDate(projectId,assetId,repayDate);
    }

    @Override
    public List<RepaymentInfo> selectRepayInfoByRelDate(Date relPayDate) {
        return repaymentInfoMapper.selectRepayInfoByRelDate(relPayDate);
    }

    @Override
    public List<RepaymentInfo> selectRepayInfoMoreThanRelDate(String assetId,Date relPayDate) {
        return repaymentInfoMapper.selectRepayInfoMoreThanRelDate(assetId,relPayDate);
    }

    @Override
    public List<RepaymentInfo> selectByCompositeKeys(String projectId, String assetId, String agencyId) {
        return repaymentInfoMapper.selectByCompositeKeys(projectId,assetId,agencyId);
    }

    @Override
    public RepaymentInfo selectByProjectIdAndPeriod(String projectId, String assetId, int period) {
        return repaymentInfoMapper.selectByProjectIdAndPeriod(projectId,assetId,period);
    }

    @Override
    public List<RepaymentInfo> selectUnionByRelDate(String projectId, String assetId, Date relPayDate) {
        return repaymentInfoMapper.selectUnionByRelDate(projectId,assetId,relPayDate);
    }

    @Override
    public RepaymentInfo selectUnionByRelDateAndPeriod(String projectId, String assetId, Date relPayDate, int period) {
        return repaymentInfoMapper.selectUnionByRelDateAndPeriod(projectId,assetId,relPayDate,period);
    }

    @Override
    public List<RepaymentInfo> selectByPeriodKey(String projectId, String assetId, int period,Date relPayDate) {
        return repaymentInfoMapper.selectByPeriodKey(projectId, assetId, period,relPayDate);
    }

    @Override
    public RepaymentInfo selectRepayInfoByUnionAndRelPayDate(String projectId, String assetId, Date relPayDate) {
        return repaymentInfoMapper.selectRepayInfoByUnionAndRelPayDate(projectId,assetId,relPayDate);
    }

    @Override
    public RepaymentInfo selectByProjectId(String projectId) {
        return repaymentInfoMapper.selectByProjectId(projectId);
    }


    @Override
    public List<RepaymentInfo> selectNormalData(String projectId, String assetId) {
        return repaymentInfoMapper.selectNormalData(projectId, assetId);
    }

    @Override
    public List<RepaymentInfo> selectRepaymentInfoStatus(String projectId, String assetId, String status) {
        return repaymentInfoMapper.selectRepaymentInfoStatus(projectId, assetId, status);
    }


    @Override
    public RepaymentInfo selectUnionByRelDateAndPeriodAndRepayDate(String projectId, String assetId, int period, Date relPayDate, Date repayDate) {
        return repaymentInfoMapper.selectUnionByRelDateAndPeriodAndRepayDate(projectId,assetId,period,relPayDate,repayDate);
    }

    @Override
    public int updateRelFeeByZero(RepaymentInfo repaymentInfo) {
        return repaymentInfoMapper.updateRelFeeByZero(repaymentInfo);
    }

    @Override
    public List<RepaymentInfo> selectPartRepayment(String projectId, String assetId, int period, Date repayDate) {
        return repaymentInfoMapper.selectPartRepayment(projectId,assetId,period,repayDate);
    }

    @Override
    public List<RepaymentInfo> selectByUpdateTime(String projectId, String date) {
        return repaymentInfoMapper.selectByUpdateTime(projectId,date);
    }
}

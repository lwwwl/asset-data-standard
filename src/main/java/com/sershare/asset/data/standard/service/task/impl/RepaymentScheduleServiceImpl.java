package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.RepaymentSchedule;
import com.sershare.asset.data.standard.mapper.RepaymentScheduleMapper;
import com.sershare.asset.data.standard.service.task.RepaymentScheduleService;
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
public class RepaymentScheduleServiceImpl implements RepaymentScheduleService {

    @Resource
    RepaymentScheduleMapper repaymentScheduleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return repaymentScheduleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RepaymentSchedule record) {
        return repaymentScheduleMapper.insert(record);
    }

    @Override
    public int insertSelective(RepaymentSchedule record) {
        return repaymentScheduleMapper.insertSelective(record);
    }

    @Override
    public RepaymentSchedule selectByPrimaryKey(Integer id) {
        return repaymentScheduleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RepaymentSchedule record) {
        return repaymentScheduleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RepaymentSchedule record) {
        return repaymentScheduleMapper.updateByPrimaryKey(record);
    }

    @Override
    public RepaymentSchedule selectByUnionKey(String projectId, String assetId, Date repayDate) {
        return repaymentScheduleMapper.selectByUnionKey(projectId,assetId,repayDate);
    }

    @Override
    public List<RepaymentSchedule> selectListByUnionKey(String projectId, String assetId) {
        return repaymentScheduleMapper.selectListByUnionKey(projectId,assetId);
    }

    @Override
    public int deleteByUnionKey(String projectId, String assetId) {
        return repaymentScheduleMapper.deleteByUnionKey(projectId,assetId);
    }

    @Override
    public List<RepaymentSchedule> selectListByUnionKeyLessDate(String projectId, String assetId, Date statusDate) {
        return repaymentScheduleMapper.selectListByUnionKeyLessDate(projectId,assetId,statusDate);
    }

    @Override
    public List<RepaymentSchedule> selectByRepayDate(Date repayDate) {
        return repaymentScheduleMapper.selectByRepayDate(repayDate);
    }

    @Override
    public List<RepaymentSchedule> selectByCompositeKeys(String projectId, String assetId, String agencyId) {
        return repaymentScheduleMapper.selectByCompositeKeys(projectId,assetId,agencyId);
    }

    @Override
    public List<RepaymentSchedule> selectByProjectIdAndAssetId(String projectId, String assetId) {
        return repaymentScheduleMapper.selectByProjectIdAndAssetId(projectId,assetId);
    }

    @Override
    public RepaymentSchedule selectListByUnionKeyAndPeriod(String projectId,String assetId,int period) {
        return repaymentScheduleMapper.selectListByUnionKeyAndPeriod(projectId, assetId, period);
    }

    @Override
    public RepaymentSchedule selectByProjectId(String projectId) {
        return repaymentScheduleMapper.selectByProjectId(projectId);
    }

    @Override
    public List<RepaymentSchedule> selectByUpdateTime(String projectId, String date) {
        return repaymentScheduleMapper.selectByUpdateTime(projectId,date);
    }
}

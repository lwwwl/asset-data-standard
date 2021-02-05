package com.sershare.asset.data.standard.service.task.impl;

import com.sershare.asset.data.standard.entity.RepaymentSchedule;
import com.sershare.asset.data.standard.mapper.RepaymentScheduleInputMapper;
import com.sershare.asset.data.standard.service.task.RepaymentScheduleInputService;
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
public class RepaymentScheduleInputServiceImpl implements RepaymentScheduleInputService {

    @Resource
    RepaymentScheduleInputMapper repaymentScheduleInputMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return repaymentScheduleInputMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RepaymentSchedule record) {
        return repaymentScheduleInputMapper.insert(record);
    }

    @Override
    public int insertSelective(RepaymentSchedule record) {
        return repaymentScheduleInputMapper.insertSelective(record);
    }

    @Override
    public RepaymentSchedule selectByPrimaryKey(Integer id) {
        return repaymentScheduleInputMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RepaymentSchedule record) {
        return repaymentScheduleInputMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RepaymentSchedule record) {
        return repaymentScheduleInputMapper.updateByPrimaryKey(record);
    }

    @Override
    public RepaymentSchedule selectByUnionKey(String projectId, String assetId, Date repayDate) {
        return repaymentScheduleInputMapper.selectByUnionKey(projectId,assetId,repayDate);
    }

    @Override
    public RepaymentSchedule selectByUnionKey(String projectId, String assetId, int period) {
        return null;
    }

    @Override
    public List<RepaymentSchedule> selectListByUnionKey(String importId, String projectId, String assetId) {
        return repaymentScheduleInputMapper.selectListByUnionKey(importId,projectId,assetId);
    }

    @Override
    public List<RepaymentSchedule> selectImportBatchLessId(Integer id, String importId, String projectId, String assetId) {
        return repaymentScheduleInputMapper.selectImportBatchLessId(id,importId,projectId,assetId);
    }
}

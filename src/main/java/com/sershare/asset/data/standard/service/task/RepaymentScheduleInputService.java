package com.sershare.asset.data.standard.service.task;

import com.sershare.asset.data.standard.entity.RepaymentSchedule;

import java.util.Date;
import java.util.List;

public interface RepaymentScheduleInputService {
    int deleteByPrimaryKey(Integer id);

    int insert(RepaymentSchedule record);

    int insertSelective(RepaymentSchedule record);

    RepaymentSchedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RepaymentSchedule record);

    int updateByPrimaryKey(RepaymentSchedule record);

    RepaymentSchedule selectByUnionKey(String projectId, String assetId,  Date repayDate);

    RepaymentSchedule selectByUnionKey(String projectId, String assetId,  int period);

    List<RepaymentSchedule> selectListByUnionKey(String importId, String projectId, String assetId);

    List<RepaymentSchedule> selectImportBatchLessId(Integer id, String importId, String projectId, String assetId);
}
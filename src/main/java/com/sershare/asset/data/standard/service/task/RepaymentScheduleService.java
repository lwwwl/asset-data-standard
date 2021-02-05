package com.sershare.asset.data.standard.service.task;


import com.sershare.asset.data.standard.entity.RepaymentSchedule;

import java.util.Date;
import java.util.List;

public interface RepaymentScheduleService {
    int deleteByPrimaryKey(Integer id);

    int insert(RepaymentSchedule record);

    int insertSelective(RepaymentSchedule record);

    RepaymentSchedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RepaymentSchedule record);

    int updateByPrimaryKey(RepaymentSchedule record);

    RepaymentSchedule selectByUnionKey(String projectId, String assetId, Date repayDate);

    List<RepaymentSchedule> selectListByUnionKey(String projectId, String assetId);

    int deleteByUnionKey(String projectId, String assetId);

    List<RepaymentSchedule> selectListByUnionKeyLessDate(String projectId,String assetId,Date statusDate);

    List<RepaymentSchedule> selectByRepayDate( Date repayDate);

    List<RepaymentSchedule> selectByCompositeKeys( String projectId, String assetId,String agencyId);

    List<RepaymentSchedule> selectByProjectIdAndAssetId(String projectId, String assetId);

    RepaymentSchedule selectListByUnionKeyAndPeriod(String projectId, String assetId, int period);

    /**
     * 通过项目编号查询文件5数据
     * @param projectId
     * @return
     */
    RepaymentSchedule selectByProjectId(String projectId);

    List<RepaymentSchedule> selectByUpdateTime(String projectId, String date);
}
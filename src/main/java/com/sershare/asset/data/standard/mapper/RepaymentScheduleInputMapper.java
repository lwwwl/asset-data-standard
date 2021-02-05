package com.sershare.asset.data.standard.mapper;

import com.sershare.asset.data.standard.entity.RepaymentSchedule;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RepaymentScheduleInputMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RepaymentSchedule record);

    int insertSelective(RepaymentSchedule record);

    RepaymentSchedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RepaymentSchedule record);

    int updateByPrimaryKey(RepaymentSchedule record);

    RepaymentSchedule selectByUnionKey(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("repayDate") Date repayDate);

    RepaymentSchedule selectByPeriod(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("period") int period);

    List<RepaymentSchedule> selectListByUnionKey(@Param("importId") String importId, @Param("projectId") String projectId, @Param("assetId") String assetId);

    List<RepaymentSchedule> selectImportBatchLessId(@Param("id") Integer id, @Param("importId") String importId, @Param("projectId") String projectId, @Param("assetId") String assetId);
}
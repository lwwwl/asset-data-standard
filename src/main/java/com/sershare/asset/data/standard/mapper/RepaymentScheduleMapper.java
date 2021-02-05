package com.sershare.asset.data.standard.mapper;

import com.sershare.asset.data.standard.entity.RepaymentSchedule;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RepaymentScheduleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RepaymentSchedule record);

    int insertSelective(RepaymentSchedule record);

    RepaymentSchedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RepaymentSchedule record);

    int updateByPrimaryKey(RepaymentSchedule record);

    RepaymentSchedule selectByUnionKey(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("repayDate") Date repayDate);

    List<RepaymentSchedule> selectListByUnionKey(@Param("projectId") String projectId, @Param("assetId") String assetId);

    int deleteByUnionKey(@Param("projectId") String projectId, @Param("assetId") String assetId);

    List<RepaymentSchedule> selectListByUnionKeyLessDate(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("statusDate") Date statusDate);

    List<RepaymentSchedule> selectByRepayDate(@Param("repayDate") Date repayDate);

    List<RepaymentSchedule> selectByCompositeKeys(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("agencyId")String agencyId);

    List<RepaymentSchedule> selectByProjectIdAndAssetId(@Param("projectId") String projectId, @Param("assetId") String assetId);

    RepaymentSchedule selectListByUnionKeyAndPeriod(@Param("projectId") String projectId,@Param("assetId")  String assetId, @Param("period") int period);

    /**
     * 通过项目编号查询文件5数据
     * @param projectId
     * @return
     */
    RepaymentSchedule selectByProjectId(@Param("projectId") String projectId);


    List<RepaymentSchedule> selectByUpdateTime(@Param("projectId") String projectId,@Param("date")String date);
}
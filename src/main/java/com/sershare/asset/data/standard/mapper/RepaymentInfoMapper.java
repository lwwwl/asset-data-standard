package com.sershare.asset.data.standard.mapper;

import com.sershare.asset.data.standard.entity.RepaymentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RepaymentInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RepaymentInfo record);

    int insertSelective(RepaymentInfo record);

    RepaymentInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RepaymentInfo record);

    int updateByPrimaryKey(RepaymentInfo record);

    RepaymentInfo selectByUnionKey(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("repayDate") Date repayDate);

    List<RepaymentInfo> selectListByUnionKeyLessDate(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("statusDate") Date statusDate);

    List<RepaymentInfo> selectAllRepaymentInfo(@Param("projectId") String projectId, @Param("assetId") String assetId);

    List<RepaymentInfo> selectRepayInfoByLessDate(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("repayDate") Date repayDate);

    List<RepaymentInfo> selectRepayInfoByRelDate(@Param("relPayDate") Date relPayDate);

    List<RepaymentInfo> selectRepayInfoMoreThanRelDate(@Param("assetId") String assetId,@Param("relPayDate") Date relPayDate);

    List<RepaymentInfo> selectByCompositeKeys(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("agencyId")String agencyId);

    RepaymentInfo selectByProjectIdAndPeriod(@Param("projectId") String projectId, @Param("assetId") String assetId,@Param("period")int period);

    List<RepaymentInfo> selectUnionByRelDate(@Param("projectId") String projectId, @Param("assetId") String assetId,@Param("relPayDate")Date relPayDate);

    RepaymentInfo selectUnionByRelDateAndPeriod(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("relPayDate") Date relPayDate,@Param("period") int period);

    List<RepaymentInfo> selectByPeriodKey(@Param("projectId") String projectId, @Param("assetId") String assetId, @Param("period") int period,@Param("relPayDate")Date relPayDate);

    /**
     * 根据项目号、借据号、实际还清日期查找实还信息
     * @author v_wangpeng
     * @date 2018/12/26 18:45
     * @param projectId 项目编号
     * @param assetId 资产借据号
     * @param relPayDate 实际还清日期
     * @return  实还信息
     */
    RepaymentInfo selectRepayInfoByUnionAndRelPayDate(@Param("projectId") String projectId, @Param("assetId") String assetId,@Param("relPayDate")Date relPayDate);

    /**
     * 通过项目编号查询文件7数据
     * @param projectId 项目编号
     * @return 实还信息
     */
    RepaymentInfo selectByProjectId(@Param("projectId") String projectId);

    /**
     * 根据项目编号和借据号查询并排序期次
     * @param projectId 项目编号
     * @param assetId 借据号
     * @return 实还信息
     */
    List<RepaymentInfo> selectNormalData(@Param("projectId") String projectId, @Param("assetId") String assetId);

    /**
     * 根据项目编号和不为修复的借据号查询
     * @param projectId
     * @param assetId
     * @param status
     * @return 实还信息
     */
    List<RepaymentInfo> selectRepaymentInfoStatus(@Param("projectId")String projectId, @Param("assetId")String assetId, @Param("status")String status);


    RepaymentInfo selectUnionByRelDateAndPeriodAndRepayDate(@Param("projectId")String projectId, @Param("assetId")String assetId,@Param("period")int period,@Param("relPayDate")Date relPayDate,@Param("repayDate") Date repayDate);


    int countRepayment();

    List<RepaymentInfo> selectRepayment(@Param("start")int start,@Param("end")int end);

    int updateRelFeeByZero(RepaymentInfo repaymentInfo);

    /**
     * 查询部分还款情况
     * @param projectId
     * @param assetId
     * @param period
     * @param repayDate
     * @return
     */
    List<RepaymentInfo> selectPartRepayment(@Param("projectId")String projectId, @Param("assetId")String assetId,@Param("period")int period,@Param("repayDate") Date repayDate);

    List<RepaymentInfo> selectByUpdateTime(@Param("projectId") String projectId, @Param("date")String date);
}
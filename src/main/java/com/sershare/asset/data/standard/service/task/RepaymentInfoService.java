package com.sershare.asset.data.standard.service.task;


import com.sershare.asset.data.standard.entity.RepaymentInfo;

import java.util.Date;
import java.util.List;

public interface RepaymentInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(RepaymentInfo record);

    int insertSelective(RepaymentInfo record);

    RepaymentInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RepaymentInfo record);

    int updateByPrimaryKey(RepaymentInfo record);

    RepaymentInfo selectByUnionKey(String projectId, String assetId, Date repayDate);

    List<RepaymentInfo> selectListByUnionKeyLessDate(String projectId, String assetId, Date statusDate);

    List<RepaymentInfo> selectAllRepaymentInfo(String projectId, String assetId);

    List<RepaymentInfo> selectRepayInfoByLessDate(String projectId, String assetId,  Date repayDate);

    List<RepaymentInfo> selectRepayInfoByRelDate(Date relPayDate);

    List<RepaymentInfo> selectRepayInfoMoreThanRelDate(String assetId, Date relPayDate);

    List<RepaymentInfo> selectByCompositeKeys( String projectId,  String assetId,String agencyId);

    RepaymentInfo selectByProjectIdAndPeriod(String projectId, String assetId,int period);

    List<RepaymentInfo> selectUnionByRelDate(String projectId, String assetId,Date relPayDate);

    RepaymentInfo selectUnionByRelDateAndPeriod(String projectId, String assetId, Date relPayDate, int period);

    List<RepaymentInfo> selectByPeriodKey(String projectId, String assetId, int period,Date relPayDate);

    /**
     * 根据项目号、借据号、实际还清日期查找实还信息
     * @author v_wangpeng
     * @date 2018/12/26 18:45
     * @param projectId 项目编号
     * @param assetId 资产借据号
     * @param relPayDate 实际还清日期
     * @return  实还信息
     */
    RepaymentInfo selectRepayInfoByUnionAndRelPayDate(String projectId,String assetId, Date relPayDate);

    /**
     * 通过项目编号查询文件7数据
     * @param projectId 项目编号
     * @return 实还信息
     */
    RepaymentInfo selectByProjectId(String projectId);

    /**
     * 根据项目编号和借据号查询并排序期次
     * @param projectId 项目编号
     * @param assetId 借据号
     * @return 实还信息
     */
    List<RepaymentInfo> selectNormalData(String projectId, String assetId);

    /**
     * 根据项目编号和不为修复的借据号查询
     * @param projectId
     * @param assetId
     * @param status
     * @return 实还信息
     */
    List<RepaymentInfo> selectRepaymentInfoStatus(String projectId, String assetId, String status);

    RepaymentInfo selectUnionByRelDateAndPeriodAndRepayDate(String projectId, String assetId, int period, Date relPayDate, Date repayDate);

    int updateRelFeeByZero(RepaymentInfo repaymentInfo);

    /**
     * 查询部分还款情况
     * @param projectId
     * @param assetId
     * @param period
     * @param repayDate
     * @return
     */
    List<RepaymentInfo> selectPartRepayment(String projectId, String assetId,int period, Date repayDate);


    List<RepaymentInfo> selectByUpdateTime(String projectId, String date);
}
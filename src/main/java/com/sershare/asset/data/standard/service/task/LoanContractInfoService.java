package com.sershare.asset.data.standard.service.task;



import com.sershare.asset.data.standard.entity.LoanContractInfo;

import java.util.List;

public interface LoanContractInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanContractInfo record);

    int insertSelective(LoanContractInfo record);

    LoanContractInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanContractInfo record);

    int updateByPrimaryKey(LoanContractInfo record);

    LoanContractInfo selectByUnionKey(String projectId, String assetId);

    LoanContractInfo selectByCompositeKeys(String projectId, String assetId, String agencyId);

    List<LoanContractInfo> selectAllData();

    /**
     * 按项目编号及数据校验状态为正常查询
     *
     * @param projectId    项目编号
     * @param verifyStatus 数据校验状态
     * @return
     */
    List<LoanContractInfo> selectNormalData(String projectId, String verifyStatus);

    /**
     * 通过项目编号查询文件1数据
     *
     * @param projectId
     * @return
     */
    LoanContractInfo selectByProjectId(String projectId);

    /**
     * 查找所有资产借据号
     *
     * @param projectId 项目编号
     * @return 借据号集合
     */
    List<String> findAllSerialNumberByProjectId(String projectId);


    List<LoanContractInfo> selectAllAssetByProjectId(String projectId);


    List<LoanContractInfo> selectByProjectIdAndFlag(String projectId, String absPushFlag);

    List<LoanContractInfo> selectByKeys(String projectId, String assetId);

}
package com.sershare.asset.data.standard.mapper;

import com.sershare.asset.data.standard.entity.LoanContractInfo;
import com.sershare.asset.data.standard.model.AssetQueryBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LoanContractInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanContractInfo record);

    int insertSelective(LoanContractInfo record);

    LoanContractInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanContractInfo record);

    int updateByPrimaryKey(LoanContractInfo record);

    LoanContractInfo selectByUnionKey(@Param("projectId") String projectId, @Param("assetId") String assetId);


    int getAssetDataCountByAssetQueryBean(AssetQueryBean assetQueryBean);

    List<Map<String,Object>> getAssetDataByAssetQueryBean(AssetQueryBean assetQueryBean);

    LoanContractInfo selectByCompositeKeys(@Param("projectId") String projectId, @Param("assetId") String assetId,@Param("agencyId")String agencyId);

    List<LoanContractInfo> selectAllData();

    /**
     * 通过合同编号查询贷款合同信息
     * @param contractCode
     * @return
     */
    LoanContractInfo selectByContractCode(@Param("contractCode") String contractCode);

    /**
     * 按项目编号及数据校验状态为正常查询
     * @param projectId 项目编号
     * @param verifyStatus 数据校验状态
     * @return
     */
    List<LoanContractInfo> selectNormalData(@Param("projectId")String projectId, @Param("verifyStatus") String verifyStatus);

    /**
     * 通过项目编号查询文件1数据
     * @param projectId
     * @return
     */
    LoanContractInfo selectByProjectId(@Param("projectId") String projectId);

    /**
     * 查找所有资产借据号
     * @param projectId 项目编号
     * @return 借据号集合
     */
    List<String> findAllSerialNumberByProjectId(@Param("projectId") String projectId);

    /**
     * 根据项目id获取所有的资产信息
     * @param projectId 项目编号
     * @return 资产数据集合
     */
    List<LoanContractInfo> selectAllAssetByProjectId(String projectId);


    List<LoanContractInfo> selectByProjectIdAndFlag(@Param("projectId") String projectId,@Param("absPushFlag") String absPushFlag);

    List<LoanContractInfo> selectByKeys(@Param("projectId") String projectId,@Param("assetId") String assetId);

    Map<String, Object> selectLoanTotalAmountByAssetId(@Param("assetId") String assetId);
}